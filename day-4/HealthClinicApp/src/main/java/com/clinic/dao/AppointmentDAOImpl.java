package com.clinic.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.clinic.dto.Appointment;
import com.clinic.dto.Doctor;
import com.clinic.dto.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentDAOImpl implements AppointmentDAO {
    private final JdbcTemplate jdbcTemplate;
    public AppointmentDAOImpl(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Appointment save(Appointment appointment) {
        KeyHolder keys = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO appointments (patient_id,doctor_id,appointment_date,status) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, appointment.getPatient().getPatientId()); statement.setInt(2, appointment.getDoctor().getDoctorId());
            statement.setObject(3, appointment.getAppointmentDate()); statement.setString(4, appointment.getStatus().name()); return statement;
        }, keys);
        appointment.setAppointmentId(keys.getKey().intValue()); return appointment;
    }

    @Override
    public int update(Appointment appointment) {
        return jdbcTemplate.update("UPDATE appointments SET patient_id=?,doctor_id=?,appointment_date=?,status=? WHERE appointment_id=?",
                appointment.getPatient().getPatientId(), appointment.getDoctor().getDoctorId(), appointment.getAppointmentDate(), appointment.getStatus().name(), appointment.getAppointmentId());
    }
    @Override public int updateStatus(int id, Appointment.Status status) { return jdbcTemplate.update("UPDATE appointments SET status=? WHERE appointment_id=?", status.name(), id); }
    @Override public int deleteById(int id) { return jdbcTemplate.update("DELETE FROM appointments WHERE appointment_id=?", id); }
    @Override public Optional<Appointment> findById(int id) { return jdbcTemplate.query("SELECT * FROM appointments WHERE appointment_id=?", rowMapper(), id).stream().findFirst(); }
    @Override public List<Appointment> findAll() { return jdbcTemplate.query("SELECT * FROM appointments ORDER BY appointment_date", rowMapper()); }

    private org.springframework.jdbc.core.RowMapper<Appointment> rowMapper() {
        return (rs, row) -> Appointment.builder().appointmentId(rs.getInt("appointment_id"))
                .patient(Patient.builder().patientId(rs.getInt("patient_id")).build())
                .doctor(Doctor.builder().doctorId(rs.getInt("doctor_id")).build())
                .appointmentDate(rs.getObject("appointment_date", java.time.LocalDateTime.class))
                .status(Appointment.Status.valueOf(rs.getString("status"))).build();
    }
}
