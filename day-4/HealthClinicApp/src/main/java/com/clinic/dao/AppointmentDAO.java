package com.clinic.dao;

import java.util.List;
import java.util.Optional;
import com.clinic.dto.Appointment;

public interface AppointmentDAO {
    Appointment save(Appointment appointment);
    int update(Appointment appointment);
    int updateStatus(int appointmentId, Appointment.Status status);
    int deleteById(int appointmentId);
    Optional<Appointment> findById(int appointmentId);
    List<Appointment> findAll();
    default int bookAppointment(Appointment appointment) { return save(appointment).getAppointmentId(); }
    default Appointment getAppointmentById(int id) { return findById(id).orElse(null); }
}
