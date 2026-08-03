show databases;
use health_clinic;
DROP TABLE IF EXISTS patients;
DROP TABLE IF EXISTS doctors;
CREATE TABLE patients (
patient_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
date_of_birth DATE,
gender ENUM('Male', 'Female', 'Other'),
email VARCHAR(100) UNIQUE,
registered_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE patient_phones (
phone_id INT AUTO_INCREMENT PRIMARY KEY,
patient_id INT NOT NULL,
phone_number VARCHAR(15) NOT NULL,
FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE,
INDEX idx_patient_id (patient_id)
);

CREATE TABLE doctors (
doctor_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
phone_number VARCHAR(15) UNIQUE,
email VARCHAR(100) UNIQUE
);

CREATE TABLE specializations (
specialization_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL UNIQUE,
description VARCHAR(255)
);

CREATE TABLE doctor_specializations (
doctor_id INT,
specialization_id INT,
PRIMARY KEY (doctor_id, specialization_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE CASCADE,
FOREIGN KEY (specialization_id) REFERENCES specializations(specialization_id) ON DELETE
CASCADE
);

CREATE TABLE appointments (
appointment_id INT AUTO_INCREMENT PRIMARY KEY,
patient_id INT NOT NULL,
doctor_id INT NOT NULL,
appointment_date DATETIME NOT NULL,
status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
FOREIGN KEY (patient_id) REFERENCES patients(patient_id),
FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id),
INDEX idx_patient_id (patient_id),
INDEX idx_doctor_date (doctor_id, appointment_date) -- composite index
);

CREATE TABLE billing (
bill_id INT AUTO_INCREMENT PRIMARY KEY,
appointment_id INT NOT NULL UNIQUE, -- UNIQUE enforces 1:1
amount DECIMAL(10,2) NOT NULL,
payment_status ENUM('Pending', 'Paid', 'Refunded') DEFAULT 'Pending',
billing_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

CREATE TABLE visit_history(
visit_id INT AUTO_INCREMENT PRIMARY KEY,
appointment_id INT NOT NULL UNIQUE, -- UNIQUE enforces 1:1
diagnosis VARCHAR(255),
prescription VARCHAR(255),
visit_notes TEXT,
FOREIGN KEY (appointment_id) REFERENCES appointments(appointment_id)
);

INSERT INTO patients (first_name, last_name, date_of_birth, gender, email)
VALUES ('Ramesh', 'Kumar', '1979-05-14', 'Male', 'ramesh@email.com');

INSERT INTO patient_phones(patient_id, phone_number) VALUES (1, '9876543210'), (1, '9998887777');

INSERT INTO doctors(first_name, last_name, phone_number, email)
VALUES ('Anjali', 'Rao', '9123456780', 'dr.rao@clinic.com');

INSERT INTO specializations(name, description)
VALUES ('Cardiology', 'Heart-related treatment'), ('Pediatrics', 'Child healthcare');

INSERT INTO doctor_specializations(doctor_id, specialization_id) VALUES (1, 1);

INSERT INTO appointments(patient_id, doctor_id, appointment_date, status)
VALUES (1, 1, '2026-08-05 10:00:00', 'Scheduled');

INSERT INTO billing(appointment_id, amount, payment_status)
VALUES (1, 1500.00, 'Pending');


INSERT INTO visit_history(appointment_id, diagnosis, prescription, visit_notes)
VALUES (1, 'Routine Checkup', 'None', 'Patient in good health');

SELECT p.first_name, p.last_name, d.first_name AS doctor_name, a.appointment_date, b.amount, v.diagnosis
FROM appointments a
JOIN patients p ON a.patient_id = p.patient_id
JOIN doctors d ON a.doctor_id = d.doctor_id
JOIN billing b ON a.appointment_id = b.appointment_id
JOIN visit_history v ON a.appointment_id = v.appointment_id;

CREATE TABLE rooms (
    room_id INT AUTO_INCREMENT PRIMARY KEY,
    room_number VARCHAR(10) NOT NULL UNIQUE,
    floor INT NOT NULL,
    room_type VARCHAR(50) DEFAULT 'Consultation'
);

INSERT INTO rooms(room_number, floor, room_type)
VALUES
('A101',1,'Consultation'),
('B205',2,'Consultation'),
('C301',3,'Emergency');

INSERT INTO doctor_room
VALUES
(1,1,'2026-08-01');


SELECT
d.first_name,
d.last_name,
r.room_number,
r.floor
FROM doctor_room dr
JOIN doctors d
ON dr.doctor_id=d.doctor_id
JOIN rooms r
ON dr.room_id=r.room_id;


EXPLAIN
SELECT *
FROM appointments
WHERE status='Scheduled';


EXPLAIN
SELECT *
FROM appointments
WHERE patient_id=1;


EXPLAIN
SELECT *
FROM appointments
WHERE doctor_id=1
AND appointment_date='2026-08-05 10:00:00';




CREATE INDEX idx_cover_doctor
ON appointments
(
doctor_id,
appointment_date,
status
);


EXPLAIN FORMAT=TRADITIONAL
SELECT *
FROM appointments
WHERE patient_id=1;

EXPLAIN FORMAT=JSON
SELECT *
FROM appointments
WHERE doctor_id=1;