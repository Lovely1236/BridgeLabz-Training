package com.college.service;

import com.college.dto.FacultyDto;
import com.college.entity.Faculty;
import com.college.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public FacultyDto createFaculty(FacultyDto facultyDto) {
        if (facultyRepository.findByEmail(facultyDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Faculty with this email already exists");
        }

        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        faculty.setEmail(facultyDto.getEmail());
        faculty.setDepartment(facultyDto.getDepartment());
        faculty.setDesignation(facultyDto.getDesignation());

        Faculty savedFaculty = facultyRepository.save(faculty);
        return mapToDto(savedFaculty);
    }

    public List<FacultyDto> getAllFaculties() {
        return facultyRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public FacultyDto getFacultyById(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Faculty not found with id: " + id));
        return mapToDto(faculty);
    }

    public FacultyDto updateFaculty(Long id, FacultyDto facultyDto) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Faculty not found with id: " + id));

        faculty.setName(facultyDto.getName());
        faculty.setEmail(facultyDto.getEmail());
        faculty.setDepartment(facultyDto.getDepartment());
        faculty.setDesignation(facultyDto.getDesignation());

        return mapToDto(facultyRepository.save(faculty));
    }

    public void deleteFaculty(Long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Faculty not found with id: " + id));
        facultyRepository.delete(faculty);
    }

    private FacultyDto mapToDto(Faculty faculty) {
        return new FacultyDto(faculty.getId(), faculty.getName(), faculty.getEmail(), faculty.getDepartment(), faculty.getDesignation());
    }
}
