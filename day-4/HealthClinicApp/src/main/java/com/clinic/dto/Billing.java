package com.clinic.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "billing")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Billing {
    public enum PaymentStatus { Pending, Paid, Refunded }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Integer billId;

    @NotNull(message = "Appointment ID is required")
    @Column(name = "appointment_id", nullable = false, unique = true)
    private Integer appointmentId;

    @DecimalMin(value = "0.01", message = "Billing amount must be positive")
    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false, length = 10)
    @Builder.Default
    private PaymentStatus paymentStatus = PaymentStatus.Pending;

    @Column(name = "billing_date", insertable = false, updatable = false)
    private LocalDateTime billingDate;

    @OneToOne
    @JoinColumn(name = "appointment_id", insertable = false, updatable = false)
    private Appointment appointment;
}
