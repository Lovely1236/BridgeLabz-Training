package com.clinic.service;

import java.math.BigDecimal;

import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dto.Appointment;
import com.clinic.dto.Billing;
import com.clinic.dto.VisitHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentService {
    private static final Logger log = LoggerFactory.getLogger(AppointmentService.class);

    private final AppointmentDAO appointmentDAO;
    private final BillingDAO billingDAO;
    private final VisitHistoryDAO visitHistoryDAO;

    public AppointmentService(AppointmentDAO appointmentDAO, BillingDAO billingDAO, VisitHistoryDAO visitHistoryDAO) {
        this.appointmentDAO = appointmentDAO;
        this.billingDAO = billingDAO;
        this.visitHistoryDAO = visitHistoryDAO;
    }

    @Transactional
    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis) {
        return completeAppointment(appointmentId, amount, diagnosis, null, null);
    }

    @Transactional
    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis, String prescription, String visitNotes) {
        if (amount == null || amount.signum() <= 0) throw new IllegalArgumentException("Billing amount must be positive");
        if (diagnosis == null || diagnosis.isBlank()) throw new IllegalArgumentException("Diagnosis cannot be blank");

        Appointment appointment = appointmentDAO.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found: " + appointmentId));
        if (appointment.getStatus() != Appointment.Status.Scheduled) {
            throw new IllegalStateException("Only scheduled appointments can be completed");
        }

        try {
            if (appointmentDAO.updateStatus(appointmentId, Appointment.Status.Completed) != 1) {
                throw new IllegalStateException("Appointment status could not be updated");
            }
            billingDAO.generateBill(Billing.builder().appointmentId(appointmentId).amount(amount).paymentStatus(Billing.PaymentStatus.Pending).build());
            visitHistoryDAO.save(VisitHistory.builder().appointmentId(appointmentId).diagnosis(diagnosis).prescription(prescription).visitNotes(visitNotes).build());
            log.info("Appointment {} completed; billing and visit history created", appointmentId);
            return true;
        } catch (DataIntegrityViolationException exception) {
            log.error("Completion transaction failed for appointment {}", appointmentId, exception);
            throw new IllegalStateException("Appointment completion could not be saved; all changes were rolled back", exception);
        }
    }
}
