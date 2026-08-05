package com.clinic.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.clinic.dto.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDAOImpl implements PatientDAO {
    private final JdbcTemplate jdbcTemplate;

    public PatientDAOImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Patient save(Patient patient) {
        String sql = "INSERT INTO patients (first_name,last_name,date_of_birth,gender,phone_number,email,is_active) VALUES (?,?,?,?,?,?,?)";
        KeyHolder keys = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, patient.getFirstName()); statement.setString(2, patient.getLastName());
            statement.setObject(3, patient.getDateOfBirth()); statement.setString(4, patient.getGender());
            statement.setString(5, patient.getPhoneNumber()); statement.setString(6, patient.getEmail());
            statement.setBoolean(7, patient.getActive() == null || patient.getActive());
            return statement;
        }, keys);
        patient.setPatientId(keys.getKey().intValue());
        return patient;
    }

    @Override
    public int update(Patient patient) {
        return jdbcTemplate.update("UPDATE patients SET first_name=?,last_name=?,date_of_birth=?,gender=?,phone_number=?,email=?,is_active=? WHERE patient_id=?",
                patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getGender(),
                patient.getPhoneNumber(), patient.getEmail(), patient.getActive(), patient.getPatientId());
    }

    @Override public int deleteById(int patientId) { return jdbcTemplate.update("DELETE FROM patients WHERE patient_id=?", patientId); }

    @Override
    public Optional<Patient> findById(int patientId) {
        List<Patient> patients = jdbcTemplate.query("SELECT * FROM patients WHERE patient_id=?", patientRowMapper(), patientId);
        return patients.stream().findFirst();
    }

    @Override public List<Patient> findAll() { return jdbcTemplate.query("SELECT * FROM patients ORDER BY patient_id", patientRowMapper()); }
    @Override public boolean existsByEmail(String email) { return Boolean.TRUE.equals(jdbcTemplate.queryForObject("SELECT COUNT(*) > 0 FROM patients WHERE email=?", Boolean.class, email)); }

    private org.springframework.jdbc.core.RowMapper<Patient> patientRowMapper() {
        return (rs, row) -> Patient.builder().patientId(rs.getInt("patient_id")).firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name")).dateOfBirth(rs.getObject("date_of_birth", java.time.LocalDate.class))
                .gender(rs.getString("gender")).phoneNumber(rs.getString("phone_number")).email(rs.getString("email"))
                .active(rs.getBoolean("is_active")).registeredOn(rs.getObject("registered_on", java.time.LocalDateTime.class)).build();
    }
}
