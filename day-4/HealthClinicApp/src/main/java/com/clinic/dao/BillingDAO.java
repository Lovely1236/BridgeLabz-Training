package com.clinic.dao;

import java.util.List;
import java.util.Optional;
import com.clinic.dto.Billing;

public interface BillingDAO {
    Billing generateBill(Billing billing);
    int updatePaymentStatus(int billId, Billing.PaymentStatus paymentStatus);
    Optional<Billing> findById(int billId);
    Optional<Billing> findByAppointmentId(int appointmentId);
    List<Billing> findAll();
    default Billing getBillById(int id) { return findById(id).orElse(null); }
}
