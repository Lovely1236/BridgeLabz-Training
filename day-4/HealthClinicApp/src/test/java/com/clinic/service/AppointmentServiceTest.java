package com.clinic.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dto.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppointmentServiceTest {
    @Mock private AppointmentDAO appointmentDAO;
    @Mock private BillingDAO billingDAO;
    @Mock private VisitHistoryDAO visitHistoryDAO;

    private AppointmentService service;

    @BeforeEach
    void setUp() { service = new AppointmentService(appointmentDAO, billingDAO, visitHistoryDAO); }

    @Test
    void completeAppointmentCoordinatesAllThreeWrites() {
        Appointment appointment = Appointment.builder().appointmentId(1).status(Appointment.Status.Scheduled).build();
        when(appointmentDAO.findById(1)).thenReturn(java.util.Optional.of(appointment));
        when(appointmentDAO.updateStatus(1, Appointment.Status.Completed)).thenReturn(1);

        service.completeAppointment(1, new BigDecimal("500.00"), "Flu", "Rest", "Follow-up in one week");

        verify(appointmentDAO).updateStatus(1, Appointment.Status.Completed);
        verify(billingDAO).generateBill(any());
        verify(visitHistoryDAO).save(any());
    }

    @Test
    void completeAppointmentRejectsNonScheduledAppointment() {
        when(appointmentDAO.findById(1)).thenReturn(java.util.Optional.of(
                Appointment.builder().appointmentId(1).status(Appointment.Status.Cancelled).build()));

        assertThrows(IllegalStateException.class,
                () -> service.completeAppointment(1, new BigDecimal("500.00"), "Flu"));
    }
}
