package com.college.service;

import com.college.dto.StudentDto;
import com.college.entity.Student;
import com.college.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDto createStudent(StudentDto studentDto) {
        if (studentRepository.findByEmail(studentDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Student with this email already exists");
        }

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setDepartment(studentDto.getDepartment());

        Student savedStudent = studentRepository.save(student);
        return mapToDto(savedStudent);
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        return mapToDto(student);
    }

    public StudentDto updateStudent(Long id, StudentDto studentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));

        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setDepartment(studentDto.getDepartment());

        return mapToDto(studentRepository.save(student));
    }

    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
        studentRepository.delete(student);
    }

    private StudentDto mapToDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getDepartment());
    }
}
