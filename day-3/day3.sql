show databases;
use health_clinic;
CREATE TABLE IF NOT EXISTS rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10) NOT NULL UNIQUE,
    floor INT NOT NULL,
    room_type VARCHAR(50) DEFAULT 'Consultation'
);

CREATE TABLE IF NOT EXISTS doctor_room (
    doctor_room_id INT AUTO_INCREMENT PRIMARY KEY,
    doctor_id INT NOT NULL,
    room_id INT NOT NULL,
    assigned_on DATE NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE CASCADE,
    FOREIGN KEY (room_id) REFERENCES rooms(room_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS audit_log (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    action VARCHAR(20) NOT NULL,
    table_name VARCHAR(50) NOT NULL,
    record_id INT NOT NULL,
    action_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS deleted_patients_archive (
    archive_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT NOT NULL,
    name VARCHAR(100),
    deleted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO rooms (room_number, floor, room_type)
VALUES('A107', 1, 'Consultation'),
('B20', 2, 'Consultation'),
('C30', 3, 'Emergency');

INSERT INTO doctors (first_name, last_name, phone_number, email)
VALUES('Kavi', 'Naira', '9812345678', 'dr.naira@clinic.com');


INSERT INTO specializations (name, description)
VALUES('Dermatology', 'Skin-related treatment'),
('Orthopedics', 'Bone and joint treatment');

INSERT INTO doctor_specializations (doctor_id, specialization_id)
VALUES(2, 2);

SELECT 
    p.first_name,
    p.last_name,
    d.first_name AS doctor_name,
    a.appointment_date,
    a.status
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id;

SELECT 
    p.first_name,
    p.last_name,
    a.appointment_date
FROM patients p
LEFT JOIN appointments a ON p.patient_id = a.patient_id;

SELECT 
    p.first_name,
    p.last_name
FROM patients p
LEFT JOIN appointments a ON p.patient_id = a.patient_id
WHERE a.appointment_id IS NULL;

SELECT 
    d.first_name,
    d.last_name,
    a.appointment_date
FROM appointments a
RIGHT JOIN doctors d ON a.doctor_id = d.doctor_id;

SELECT 
    p.first_name AS patient_name,
    d.first_name AS doctor_name,
    s.name AS specialization,
    a.appointment_date,
    b.amount,
    b.payment_status
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id
JOIN doctor_specializations ds ON d.doctor_id = ds.doctor_id
JOIN specializations s ON ds.specialization_id = s.specialization_id
LEFT JOIN billing b ON a.appointment_id = b.appointment_id;

-- ==========================
-- 4) Stored Procedures
-- ==========================

DELIMITER //

CREATE PROCEDURE GetPatientAppointments(IN p_id INT)
BEGIN
    SELECT 
        a.appointment_id,
        a.appointment_date,
        d.first_name AS doctor_name,
        a.status
    FROM appointments a
    JOIN doctors d ON a.doctor_id = d.doctor_id
    WHERE a.patient_id = p_id
    ORDER BY a.appointment_date;
END //

CREATE PROCEDURE GetPatientCount(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM patients;
END //

CREATE PROCEDURE ApplyDiscount(INOUT amount DECIMAL(10,2), IN pct DECIMAL(5,2))
BEGIN
    SET amount = amount - (amount * pct / 100);
END //

CREATE PROCEDURE BookAppointment(
    IN p_id INT,
    IN d_id INT,
    IN apt_date DATETIME
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Appointment could not be booked' AS message;
    END;

    START TRANSACTION;
    INSERT INTO appointments (patient_id, doctor_id, appointment_date, status)
    VALUES (p_id, d_id, apt_date, 'Scheduled');
    COMMIT;
END //

DELIMITER ;



-- ==========================
-- 5) Call the procedures
-- ==========================

CALL GetPatientAppointments(1);

CALL GetPatientCount(@count);
SELECT @count;

SET @bill = 1500.00;
CALL ApplyDiscount(@bill, 10);
SELECT @bill;

CALL BookAppointment(1, 2, '2026-08-10 10:00:00');



-- ==========================
-- 6) Triggers
-- ==========================

DELIMITER //

DROP TRIGGER IF EXISTS before_appointment_insert;
CREATE TRIGGER before_appointment_insert
BEFORE INSERT ON appointments
FOR EACH ROW
BEGIN
    IF NEW.appointment_date < NOW() THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot book an appointment in the past';
    END IF;
END //

DROP TRIGGER IF EXISTS after_appointment_insert;
CREATE TRIGGER after_appointment_insert
AFTER INSERT ON appointments
FOR EACH ROW
BEGIN
    INSERT INTO audit_log(action, table_name, record_id)
    VALUES ('INSERT', 'appointments', NEW.appointment_id);
END //

DROP TRIGGER IF EXISTS after_appointment_update;
CREATE TRIGGER after_appointment_update
AFTER UPDATE ON appointments
FOR EACH ROW
BEGIN
    IF NEW.status = 'Completed' AND OLD.status != 'Completed' THEN
        INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes)
        VALUES (NEW.appointment_id, 'Completed Visit', 'Follow-up advised', 'Auto-generated from trigger');
    END IF;
END //

DROP TRIGGER IF EXISTS before_patient_delete;
CREATE TRIGGER before_patient_delete
BEFORE DELETE ON patients
FOR EACH ROW
BEGIN
    IF EXISTS (
        SELECT 1
        FROM appointments
        WHERE patient_id = OLD.patient_id
        AND status <> 'Cancelled'
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete a patient with active appointments';
    END IF;
END //

DROP TRIGGER IF EXISTS after_patient_delete;
CREATE TRIGGER after_patient_delete
AFTER DELETE ON patients
FOR EACH ROW
BEGIN
    INSERT INTO deleted_patients_archive(patient_id, name)
    VALUES (OLD.patient_id, CONCAT(OLD.first_name, ' ', OLD.last_name));
END //

DELIMITER ;




-- ==========================
-- 7) Test triggers
-- ==========================

-- This should fail because appointment date is in the past
INSERT INTO appointments (patient_id, doctor_id, appointment_date, status)
VALUES (1, 1, '2026-07-01 09:00:00', 'Scheduled');

-- Update appointment to Completed to fire the after update trigger
UPDATE appointments
SET status = 'Completed'
WHERE appointment_id = 1;

-- This should fail because patient has an active appointment
DELETE FROM patients WHERE patient_id = 1;