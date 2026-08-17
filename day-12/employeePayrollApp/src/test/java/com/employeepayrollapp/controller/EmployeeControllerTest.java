package com.employeepayrollapp.controller;

import com.employeepayrollapp.entity.Employee;
import com.employeepayrollapp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

        @Mock
    private EmployeeService employeeService;

        @InjectMocks
        private EmployeeController employeeController;

    @Test
    void createEmployee_shouldReturnCreated() throws Exception {
        Employee input = Employee.builder().name("Alice").department("Engineering").salary(70000.0).build();
        Employee saved = Employee.builder().id(1L).name("Alice").department("Engineering").salary(70000.0).build();
        when(employeeService.createEmployee(input)).thenReturn(saved);

                ResponseEntity<Employee> response = employeeController.createEmployee(input);

                assertEquals(HttpStatus.CREATED, response.getStatusCode());
                assertEquals(1L, response.getBody().getId());
                assertEquals("Alice", response.getBody().getName());
        verify(employeeService).createEmployee(input);
    }

    @Test
    void getAllEmployees_shouldReturnOk() throws Exception {
        List<Employee> employees = List.of(
                Employee.builder().id(1L).name("Alice").department("Engineering").salary(70000.0).build(),
                Employee.builder().id(2L).name("Bob").department("HR").salary(50000.0).build()
        );
        when(employeeService.getAllEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> response = employeeController.getAllEmployees();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("Alice", response.getBody().get(0).getName());
        assertEquals("Bob", response.getBody().get(1).getName());
        verify(employeeService).getAllEmployees();
    }

    @Test
    void getEmployeeById_shouldReturnOk() throws Exception {
        Employee employee = Employee.builder().id(1L).name("Alice").department("Engineering").salary(70000.0).build();
        when(employeeService.getEmployeeById(1L)).thenReturn(employee);

        ResponseEntity<Employee> response = employeeController.getEmployeeById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getId());
        assertEquals("Engineering", response.getBody().getDepartment());
        verify(employeeService).getEmployeeById(1L);
    }

    @Test
    void updateEmployee_shouldReturnOk() throws Exception {
        Employee update = Employee.builder().name("Alice Updated").department("Product").salary(80000.0).build();
        Employee updated = Employee.builder().id(1L).name("Alice Updated").department("Product").salary(80000.0).build();
        when(employeeService.updateEmployee(1L, update)).thenReturn(updated);

        ResponseEntity<Employee> response = employeeController.updateEmployee(1L, update);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Alice Updated", response.getBody().getName());
        assertEquals(80000.0, response.getBody().getSalary());
        verify(employeeService).updateEmployee(1L, update);
    }

    @Test
    void deleteEmployee_shouldReturnNoContent() throws Exception {
        ResponseEntity<Void> response = employeeController.deleteEmployee(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(employeeService).deleteEmployee(1L);
    }

    @Test
    void getEmployeeById_whenMissing_shouldPropagateException() {
        when(employeeService.getEmployeeById(999L))
                .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: 999"));

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> employeeController.getEmployeeById(999L));

        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode().value());
        assertTrue(exception.getReason().contains("999"));
    }

    @Test
    void deleteEmployee_whenMissing_shouldPropagateException() {
        org.mockito.Mockito.doThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: 999"))
                .when(employeeService).deleteEmployee(999L);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> employeeController.deleteEmployee(999L));

        assertEquals(HttpStatus.NOT_FOUND.value(), exception.getStatusCode().value());
        assertTrue(exception.getReason().contains("999"));
    }
}
