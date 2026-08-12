package com.college.controller;

import com.college.dto.FacultyDto;
import com.college.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping("/faculties")
    public ResponseEntity<FacultyDto> createFaculty(@RequestBody FacultyDto facultyDto) {
        FacultyDto createdFaculty = facultyService.createFaculty(facultyDto);
        return new ResponseEntity<>(createdFaculty, HttpStatus.CREATED);
    }

    @GetMapping("/faculties")
    public ResponseEntity<List<FacultyDto>> getAllFaculties() {
        return ResponseEntity.ok(facultyService.getAllFaculties());
    }

    @GetMapping("/faculties/{id}")
    public ResponseEntity<FacultyDto> getFacultyById(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.getFacultyById(id));
    }

    @PutMapping("/faculties/{id}")
    public ResponseEntity<FacultyDto> updateFaculty(@PathVariable Long id, @RequestBody FacultyDto facultyDto) {
        return ResponseEntity.ok(facultyService.updateFaculty(id, facultyDto));
    }

    @DeleteMapping("/faculties/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok("Faculty deleted successfully");
    }
}
