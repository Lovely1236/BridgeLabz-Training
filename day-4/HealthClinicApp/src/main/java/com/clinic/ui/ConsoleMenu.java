package com.clinic.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.clinic.dao.AppointmentDAO;
import com.clinic.dao.BillingDAO;
import com.clinic.dao.DoctorDAO;
import com.clinic.dao.PatientDAO;
import com.clinic.dao.SpecializationDAO;
import com.clinic.dao.VisitHistoryDAO;
import com.clinic.dto.Appointment;
import com.clinic.dto.Billing;
import com.clinic.dto.Doctor;
import com.clinic.dto.Patient;
import com.clinic.dto.Specialization;
import com.clinic.dto.VisitHistory;
import com.clinic.service.AppointmentService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "clinic.console.enabled", havingValue = "true")
public class ConsoleMenu implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ConsoleMenu.class);
    private static final DateTimeFormatter DATE_TIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private final Scanner scanner;
    private final Validator validator;
    private final PatientDAO patientDAO;
    private final DoctorDAO doctorDAO;
    private final SpecializationDAO specializationDAO;
    private final AppointmentDAO appointmentDAO;
    private final BillingDAO billingDAO;
    private final VisitHistoryDAO visitHistoryDAO;
    private final AppointmentService appointmentService;

    public ConsoleMenu(Scanner scanner, Validator validator, PatientDAO patientDAO, DoctorDAO doctorDAO,
                       SpecializationDAO specializationDAO, AppointmentDAO appointmentDAO, BillingDAO billingDAO,
                       VisitHistoryDAO visitHistoryDAO, AppointmentService appointmentService) {
        this.scanner = scanner; this.validator = validator; this.patientDAO = patientDAO; this.doctorDAO = doctorDAO;
        this.specializationDAO = specializationDAO; this.appointmentDAO = appointmentDAO; this.billingDAO = billingDAO;
        this.visitHistoryDAO = visitHistoryDAO; this.appointmentService = appointmentService;
    }

    @Override public void run(String... args) { start(); }

    public void start() {
        boolean running = true;
        while (running && scanner.hasNextLine()) {
            printMainMenu();
            try {
                switch (readInt("Choose an option: ")) {
                    case 1 -> patientMenu(); case 2 -> doctorMenu(); case 3 -> specializationMenu();
                    case 4 -> appointmentMenu(); case 5 -> billingMenu(); case 6 -> visitMenu();
                    case 0 -> running = false; default -> System.out.println("Invalid option.");
                }
            } catch (RuntimeException exception) {
                log.error("Console operation failed", exception);
                System.out.println("Operation failed: " + exception.getMessage());
            }
        }
    }

    private void printMainMenu() {
        System.out.println("\n=== Health Clinic Management ===");
        System.out.println("1. Patients  2. Doctors  3. Specializations  4. Appointments");
        System.out.println("5. Billing   6. Visit History  0. Exit");
    }

    private void patientMenu() {
        System.out.println("\n1 Add  2 Update  3 Delete  4 View by ID  5 View All  0 Back");
        switch (readInt("Choose: ")) {
            case 1 -> addPatient(); case 2 -> updatePatient(); case 3 -> deletePatient(); case 4 -> print(patientDAO.findById(readInt("Patient ID: "))); case 5 -> patientDAO.findAll().forEach(System.out::println); default -> { }
        }
    }

    private void addPatient() {
        Patient patient = Patient.builder().firstName(readText("First name: ")).lastName(readText("Last name: "))
                .dateOfBirth(readOptionalDate("Date of birth (yyyy-MM-dd, blank allowed): "))
                .gender(readOptionalText("Gender (Male/Female/Other): ")).phoneNumber(readOptionalText("Phone: ")).email(readOptionalText("Email: ")).active(true).build();
        validate(patient); patientDAO.save(patient); System.out.println("Patient created with ID " + patient.getPatientId());
    }

    private void updatePatient() {
        Patient patient = patientDAO.findById(readInt("Patient ID: ")).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        patient.setFirstName(readText("First name: ")); patient.setLastName(readText("Last name: ")); patient.setDateOfBirth(readOptionalDate("Date of birth: "));
        patient.setGender(readOptionalText("Gender: ")); patient.setPhoneNumber(readOptionalText("Phone: ")); patient.setEmail(readOptionalText("Email: ")); validate(patient);
        if (patientDAO.update(patient) != 1) throw new IllegalStateException("Patient was not updated"); System.out.println("Patient updated.");
    }
    private void deletePatient() { if (patientDAO.deleteById(readInt("Patient ID: ")) != 1) throw new IllegalArgumentException("Patient not found"); System.out.println("Patient deleted."); }

    private void doctorMenu() {
        System.out.println("\n1 Add  2 Update  3 Delete  4 View  5 View All  6 Assign Specialization  0 Back");
        switch (readInt("Choose: ")) {
            case 1 -> addDoctor(); case 2 -> updateDoctor(); case 3 -> { if (doctorDAO.deleteById(readInt("Doctor ID: ")) != 1) throw new IllegalArgumentException("Doctor not found"); }
            case 4 -> print(doctorDAO.findById(readInt("Doctor ID: "))); case 5 -> doctorDAO.findAll().forEach(System.out::println);
            case 6 -> { doctorDAO.assignSpecialization(readInt("Doctor ID: "), readInt("Specialization ID: ")); System.out.println("Specialization assigned."); } default -> { }
        }
    }
    private void addDoctor() { Doctor doctor = Doctor.builder().firstName(readText("First name: ")).lastName(readText("Last name: ")).phoneNumber(readOptionalText("Phone: ")).email(readOptionalText("Email: ")).active(true).build(); validate(doctor); doctorDAO.save(doctor); System.out.println("Doctor created with ID " + doctor.getDoctorId()); }
    private void updateDoctor() { Doctor doctor = doctorDAO.findById(readInt("Doctor ID: ")).orElseThrow(() -> new IllegalArgumentException("Doctor not found")); doctor.setFirstName(readText("First name: ")); doctor.setLastName(readText("Last name: ")); doctor.setPhoneNumber(readOptionalText("Phone: ")); doctor.setEmail(readOptionalText("Email: ")); validate(doctor); doctorDAO.update(doctor); System.out.println("Doctor updated."); }

    private void specializationMenu() {
        System.out.println("\n1 Add  2 Update  3 Delete  4 View All  0 Back");
        switch (readInt("Choose: ")) {
            case 1 -> { Specialization s = Specialization.builder().name(readText("Name: ")).description(readOptionalText("Description: ")).build(); validate(s); specializationDAO.save(s); System.out.println("Specialization created with ID " + s.getSpecializationId()); }
            case 2 -> { Specialization s = specializationDAO.findById(readInt("Specialization ID: ")).orElseThrow(() -> new IllegalArgumentException("Specialization not found")); s.setName(readText("Name: ")); s.setDescription(readOptionalText("Description: ")); validate(s); specializationDAO.update(s); }
            case 3 -> { if (specializationDAO.deleteById(readInt("Specialization ID: ")) != 1) throw new IllegalArgumentException("Specialization not found"); }
            case 4 -> specializationDAO.findAll().forEach(System.out::println); default -> { }
        }
    }

    private void appointmentMenu() {
        System.out.println("\n1 Book  2 Update  3 Cancel  4 Complete  5 View  6 View All  0 Back");
        switch (readInt("Choose: ")) {
            case 1 -> bookAppointment(); case 2 -> updateAppointment();
            case 3 -> { if (appointmentDAO.updateStatus(readInt("Appointment ID: "), Appointment.Status.Cancelled) != 1) throw new IllegalArgumentException("Appointment not found"); System.out.println("Appointment cancelled."); }
            case 4 -> completeAppointment(); case 5 -> print(appointmentDAO.findById(readInt("Appointment ID: "))); case 6 -> appointmentDAO.findAll().forEach(System.out::println); default -> { }
        }
    }
    private void bookAppointment() { int patientId = readInt("Patient ID: "); int doctorId = readInt("Doctor ID: "); Appointment appointment = Appointment.builder().patient(patientDAO.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found"))).doctor(doctorDAO.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor not found"))).appointmentDate(readDateTime("Appointment date (yyyy-MM-dd HH:mm): ")).status(Appointment.Status.Scheduled).build(); validate(appointment); appointmentDAO.save(appointment); System.out.println("Appointment booked with ID " + appointment.getAppointmentId()); }
    private void updateAppointment() { Appointment a = appointmentDAO.findById(readInt("Appointment ID: ")).orElseThrow(() -> new IllegalArgumentException("Appointment not found")); a.setAppointmentDate(readDateTime("Appointment date (yyyy-MM-dd HH:mm): ")); a.setStatus(Appointment.Status.Scheduled); appointmentDAO.update(a); System.out.println("Appointment updated."); }
    private void completeAppointment() { int id = readInt("Appointment ID: "); BigDecimal amount = new BigDecimal(readText("Bill amount: ")); String diagnosis = readText("Diagnosis: "); String prescription = readOptionalText("Prescription: "); String notes = readOptionalText("Visit notes: "); appointmentService.completeAppointment(id, amount, diagnosis, prescription, notes); System.out.println("Appointment completed; bill and visit history created."); }

    private void billingMenu() { System.out.println("\n1 Generate  2 View  3 Update Payment Status  4 View All  0 Back"); switch (readInt("Choose: ")) { case 1 -> { Billing b = Billing.builder().appointmentId(readInt("Appointment ID: ")).amount(new BigDecimal(readText("Amount: "))).paymentStatus(Billing.PaymentStatus.Pending).build(); validate(b); billingDAO.generateBill(b); System.out.println("Bill created with ID " + b.getBillId()); } case 2 -> print(billingDAO.findById(readInt("Bill ID: "))); case 3 -> { int id = readInt("Bill ID: "); Billing.PaymentStatus status = Billing.PaymentStatus.valueOf(readText("Status (Pending/Paid/Refunded): ")); billingDAO.updatePaymentStatus(id, status); System.out.println("Payment status updated."); } case 4 -> billingDAO.findAll().forEach(System.out::println); default -> { } } }
    private void visitMenu() { System.out.println("\n1 Store  2 Update  3 View  4 View All  0 Back"); switch (readInt("Choose: ")) { case 1 -> { VisitHistory v = VisitHistory.builder().appointmentId(readInt("Appointment ID: ")).diagnosis(readOptionalText("Diagnosis: ")).prescription(readOptionalText("Prescription: ")).visitNotes(readOptionalText("Visit notes: ")).build(); validate(v); visitHistoryDAO.save(v); System.out.println("Visit history stored."); } case 2 -> { VisitHistory v = visitHistoryDAO.findById(readInt("Visit ID: ")).orElseThrow(() -> new IllegalArgumentException("Visit history not found")); v.setDiagnosis(readOptionalText("Diagnosis: ")); v.setPrescription(readOptionalText("Prescription: ")); v.setVisitNotes(readOptionalText("Visit notes: ")); validate(v); visitHistoryDAO.update(v); } case 3 -> print(visitHistoryDAO.findById(readInt("Visit ID: "))); case 4 -> visitHistoryDAO.findAll().forEach(System.out::println); default -> { } } }

    private void validate(Object value) { List<String> errors = validator.validate(value).stream().map(ConstraintViolation::getMessage).toList(); if (!errors.isEmpty()) throw new IllegalArgumentException(String.join(", ", errors)); }
    private void print(Object value) { System.out.println(value == null ? "Not found." : value); }
    private int readInt(String prompt) { return Integer.parseInt(readText(prompt)); }
    private String readText(String prompt) { System.out.print(prompt); if (!scanner.hasNextLine()) throw new IllegalStateException("Input closed"); return scanner.nextLine().trim(); }
    private String readOptionalText(String prompt) { String value = readText(prompt); return value.isBlank() ? null : value; }
    private LocalDate readOptionalDate(String prompt) { String value = readText(prompt); return value.isBlank() ? null : LocalDate.parse(value); }
    private LocalDateTime readDateTime(String prompt) { return LocalDateTime.parse(readText(prompt), DATE_TIME); }
}
