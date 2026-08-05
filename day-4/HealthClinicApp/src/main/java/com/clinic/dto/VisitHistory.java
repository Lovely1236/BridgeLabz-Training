package com.clinic.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "visit_history")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "visit_id")
    private Integer visitId;

    @Column(name = "appointment_id", nullable = false, unique = true)
    private Integer appointmentId;

    @Size(max = 255, message = "Diagnosis cannot exceed 255 characters")
    @Column(name = "diagnosis", length = 255)
    private String diagnosis;

    @Size(max = 255, message = "Prescription cannot exceed 255 characters")
    @Column(name = "prescription", length = 255)
    private String prescription;

    @Column(name = "visit_notes", columnDefinition = "TEXT")
    private String visitNotes;

    @OneToOne
    @JoinColumn(name = "appointment_id", insertable = false, updatable = false)
    private Appointment appointment;
}
