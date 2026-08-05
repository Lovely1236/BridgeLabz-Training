package com.clinic.dao;

import java.util.List;
import java.util.Optional;
import com.clinic.dto.Doctor;

public interface DoctorDAO {
    Doctor save(Doctor doctor);
    int update(Doctor doctor);
    int deleteById(int doctorId);
    Optional<Doctor> findById(int doctorId);
    List<Doctor> findAll();
    int assignSpecialization(int doctorId, int specializationId);
    default int insertDoctor(Doctor doctor) { return save(doctor).getDoctorId(); }
    default Doctor getDoctorById(int id) { return findById(id).orElse(null); }
}
