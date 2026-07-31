--Health Clinic Database

CREATE DATABASE IF NOT EXISTS health_clinic;
USE health_clinic;

-- Create Patients Table
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(60) NOT NULL,
    dob DATE,
    gender ENUM ('Male', 'Female', 'Other'),
    contact_no VARCHAR(15) UNIQUE,
    email VARCHAR(100),
    registered_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- ALTER TABLE Examples
ALTER TABLE patients MODIFY email VARCHAR(80);

ALTER TABLE patients
ADD address VARCHAR(150);

ALTER TABLE patients
CHANGE address residential_address VARCHAR(150);

ALTER TABLE patients
DROP COLUMN residential_address;

-- RENAME TABLE Examples
RENAME TABLE patients TO patient_records;
RENAME TABLE patient_records TO patients;

-- Insert Sample Records
INSERT INTO patients(full_name, dob, gender, contact_no, email)
VALUES
('Rahul Sharma','1997-05-15','Male','9876543210','rahul@gmail.com'),
('Priya Singh','2000-08-22','Female','9123456789','priya@gmail.com'),
('Neha Verma','1999-11-10','Female','9988776655','neha@gmail.com');

-- Update Record
UPDATE patients
SET contact_no = '9000011111'
WHERE patient_id = 1;

-- Delete Record
DELETE FROM patients
WHERE patient_id = 3;

-- Doctors Table
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(80),
    contact_no VARCHAR(15) UNIQUE,
    email VARCHAR(100)
);

INSERT INTO doctors(first_name,last_name,specialization,contact_no,email)
VALUES
('Meera','Kapoor','Dermatology','9876500001','meera@clinic.com'),
('Amit','Joshi','Orthopedics','9876500002','amit@clinic.com');

-- Display Data
SELECT * FROM patients;
SELECT * FROM doctors;

--College Database

CREATE DATABASE IF NOT EXISTS college_db;
USE college_db;

-- Students Table
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100));

-- Enrollments Table
CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    FOREIGN KEY (student_id)
    REFERENCES students(student_id)
);

-- Composite Primary Key Example
CREATE TABLE course_orders (
    order_id INT,
    course_id INT,
    PRIMARY KEY (order_id, course_id)
);

-- Sample Data
INSERT INTO students
VALUES
(1,'Aarav'),
(2,'Diya');

INSERT INTO enrollments
VALUES
(101,1);

-- INNER JOIN
SELECT * FROM students s INNER JOIN enrollments e
ON s.student_id = e.student_id;

-- LEFT JOIN
SELECT * FROM students s LEFT JOIN enrollments e
ON s.student_id = e.student_id;

-- FULL OUTER JOIN (MySQL Alternative)
SELECT * FROM students s LEFT JOIN enrollments e
ON s.student_id = e.student_id

UNION

SELECT * FROM students s RIGHT JOIN enrollments e
ON s.student_id = e.student_id;