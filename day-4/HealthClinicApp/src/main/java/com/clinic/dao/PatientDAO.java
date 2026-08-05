package com.clinic.dao;

import java.util.List;
import java.util.Optional;
import com.clinic.dto.Patient;

public interface PatientDAO {
    Patient save(Patient patient);
    int update(Patient patient);
    int deleteById(int patientId);
    Optional<Patient> findById(int patientId);
    List<Patient> findAll();
    boolean existsByEmail(String email);

    default int insertPatient(Patient patient) { return save(patient).getPatientId(); }
    default Patient getPatientById(int id) { return findById(id).orElse(null); }
}
