package com.clinic.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.clinic.dto.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorDAOImpl implements DoctorDAO {
    private final JdbcTemplate jdbcTemplate;
    public DoctorDAOImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Doctor save(Doctor doctor) {
        KeyHolder keys = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO doctors (first_name,last_name,phone_number,email,is_active) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, doctor.getFirstName()); statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getPhoneNumber()); statement.setString(4, doctor.getEmail());
            statement.setBoolean(5, doctor.getActive() == null || doctor.getActive()); return statement;
        }, keys);
        doctor.setDoctorId(keys.getKey().intValue()); return doctor;
    }

    @Override public int update(Doctor doctor) { return jdbcTemplate.update("UPDATE doctors SET first_name=?,last_name=?,phone_number=?,email=?,is_active=? WHERE doctor_id=?", doctor.getFirstName(), doctor.getLastName(), doctor.getPhoneNumber(), doctor.getEmail(), doctor.getActive(), doctor.getDoctorId()); }
    @Override public int deleteById(int doctorId) { return jdbcTemplate.update("DELETE FROM doctors WHERE doctor_id=?", doctorId); }
    @Override public Optional<Doctor> findById(int doctorId) { return jdbcTemplate.query("SELECT * FROM doctors WHERE doctor_id=?", doctorRowMapper(), doctorId).stream().findFirst(); }
    @Override public List<Doctor> findAll() { return jdbcTemplate.query("SELECT * FROM doctors ORDER BY doctor_id", doctorRowMapper()); }
    @Override public int assignSpecialization(int doctorId, int specializationId) { return jdbcTemplate.update("INSERT INTO doctor_specializations (doctor_id,specialization_id) VALUES (?,?)", doctorId, specializationId); }

    private org.springframework.jdbc.core.RowMapper<Doctor> doctorRowMapper() {
        return (rs, row) -> Doctor.builder().doctorId(rs.getInt("doctor_id")).firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name")).phoneNumber(rs.getString("phone_number")).email(rs.getString("email"))
                .active(rs.getBoolean("is_active")).build();
    }
}
