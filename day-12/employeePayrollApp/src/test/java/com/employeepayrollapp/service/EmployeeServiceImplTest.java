package com.employeepayrollapp.service;

import com.employeepayrollapp.entity.Employee;
import com.employeepayrollapp.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void createEmployee_shouldSaveAndReturnEmployee() {
        Employee input = Employee.builder().name("Alice").department("Engineering").salary(70000.0).build();
        Employee saved = Employee.builder().id(1L).name("Alice").department("Engineering").salary(70000.0).build();
        when(employeeRepository.save(input)).thenReturn(saved);

        Employee result = employeeService.createEmployee(input);

        assertEquals(1L, result.getId());
        assertEquals("Alice", result.getName());
        verify(employeeRepository).save(input);
    }

    @Test
    void getAllEmployees_shouldReturnList() {
        List<Employee> employees = List.of(
                Employee.builder().id(1L).name("A").department("HR").salary(50000.0).build(),
                Employee.builder().id(2L).name("B").department("Sales").salary(60000.0).build()
        );
        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        verify(employeeRepository).findAll();
    }

    @Test
    void getEmployeeById_whenFound_shouldReturnEmployee() {
        Employee employee = Employee.builder().id(1L).name("Alice").department("Engineering").salary(70000.0).build();
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        Employee result = employeeService.getEmployeeById(1L);

        assertEquals("Alice", result.getName());
        verify(employeeRepository).findById(1L);
    }

    @Test
    void getEmployeeById_whenMissing_shouldThrowNotFound() {
        when(employeeRepository.findById(999L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> employeeService.getEmployeeById(999L));

        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode().value());
        assertTrue(exception.getReason().contains("999"));
    }

    @Test
    void updateEmployee_whenFound_shouldUpdateAndReturnEmployee() {
        Employee existing = Employee.builder().id(1L).name("Old").department("OldDept").salary(45000.0).build();
        Employee update = Employee.builder().name("New").department("NewDept").salary(90000.0).build();
        Employee updated = Employee.builder().id(1L).name("New").department("NewDept").salary(90000.0).build();

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(employeeRepository.save(existing)).thenReturn(updated);

        Employee result = employeeService.updateEmployee(1L, update);

        assertEquals("New", result.getName());
        assertEquals("NewDept", result.getDepartment());
        assertEquals(90000.0, result.getSalary());
        verify(employeeRepository).findById(1L);
        verify(employeeRepository).save(existing);
    }

    @Test
    void updateEmployee_whenMissing_shouldThrowNotFound() {
        Employee update = Employee.builder().name("New").department("NewDept").salary(90000.0).build();
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> employeeService.updateEmployee(1L, update));

        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode().value());
    }

    @Test
    void deleteEmployee_whenFound_shouldDeleteEmployee() {
        Employee existing = Employee.builder().id(1L).name("Delete").department("Ops").salary(40000.0).build();
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(existing));

        employeeService.deleteEmployee(1L);

        verify(employeeRepository).findById(1L);
        verify(employeeRepository).delete(existing);
    }

    @Test
    void deleteEmployee_whenMissing_shouldThrowNotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> employeeService.deleteEmployee(1L));

        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode().value());
    }
}
