package com.clinic.dao;

import java.util.List;
import java.util.Optional;
import com.clinic.dto.Specialization;

public interface SpecializationDAO {
    Specialization save(Specialization specialization);
    int update(Specialization specialization);
    int deleteById(int specializationId);
    Optional<Specialization> findById(int specializationId);
    List<Specialization> findAll();
    default int insertSpecialization(Specialization specialization) { return save(specialization).getSpecializationId(); }
}
