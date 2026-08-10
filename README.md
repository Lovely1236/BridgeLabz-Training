# 🚀 Refresher Training

## 📖 Overview

This repository documents my **Refresher Training** on **Database Management Systems (DBMS)** and **MySQL**, covering database fundamentals, SQL, schema design, normalization, indexing, query optimization, stored procedures, and triggers through the **Health Clinic Database Project**.

---

# 📚 Day 1 – DBMS & SQL Fundamentals

> **Project:** Health Clinic Database

### 🚀 Topics Covered

#### 📌 Database Fundamentals
- DBMS & RDBMS
- SQL vs NoSQL
- Relational Databases
- File System vs DBMS

#### 🐬 MySQL
- Installation & Architecture
- Database & Table Creation
- MySQL CLI

#### 📝 SQL
- DDL, DML, DQL
- TCL & DCL
- CRUD Operations

#### 🔑 Database Concepts
- Keys & Constraints
- SQL Joins
- Normalization (1NF–BCNF)

#### ⚡ Best Practices
- Query Optimization
- Performance Tuning
- Security
- Backup & Recovery
- ACID Properties

### 💻 Practical Session

- ✅ Installed & Configured MySQL
- ✅ Created Databases & Tables
- ✅ Performed CRUD Operations
- ✅ Executed SQL Queries
- ✅ Modified Table Structure
- ✅ Created Database Users

### 🎯 Learning Outcomes

- Build relational databases using MySQL
- Write SQL queries and JOINs
- Design normalized database schemas
- Apply database optimization techniques
- Follow security and industry best practices

---

# 📚 Day 2 – Advanced Database Design & Query Optimization

> **Project:** Health Clinic Database

### 🚀 Topics Covered

#### 🗂️ Database Design
- Extended Database Schema
- Rooms Table
- Doctor–Room Relationship
- Junction Tables

#### 🔗 Entity Relationships
- One-to-One
- One-to-Many
- Many-to-Many
- Foreign Keys & Cascading Deletes

#### 📐 Database Normalization
- 1NF, 2NF & 3NF
- Functional, Partial & Transitive Dependencies

#### ⚡ Query Optimization
- SQL Indexing
- Single, Composite & Covering Indexes
- EXPLAIN Statement
- Table Scan vs Index Scan

### 💻 Practical Session

- ✅ Extended the Database Schema
- ✅ Created Rooms & Doctor-Room Tables
- ✅ Inserted Sample Data
- ✅ Verified Normalization
- ✅ Created & Tested Indexes
- ✅ Analyzed Query Execution Plans using `EXPLAIN`
- ✅ Optimized SQL Queries

### 🎯 Learning Outcomes

- Design scalable relational databases
- Implement entity relationships
- Apply database normalization
- Create efficient indexing strategies
- Analyze execution plans using `EXPLAIN`
- Optimize SQL query performance

---

# 📚 Day 3 – SQL Joins, Stored Procedures & Triggers

> **Project:** Health Clinic Database

### 🚀 Topics Covered

#### 🔗 SQL Joins
- INNER, LEFT, RIGHT, FULL OUTER
- SELF JOIN
- CROSS JOIN
- Multi-table JOINs

#### ⚙️ Stored Procedures
- Creating & Calling Procedures
- IN, OUT & INOUT Parameters
- Error Handling
- Reusable Database Logic

#### 🔄 Triggers
- BEFORE & AFTER Triggers
- Audit Logging
- Data Validation
- Business Rule Enforcement

### 💻 Practical Session

- ✅ Implemented SQL JOINs
- ✅ Created Stored Procedures
- ✅ Built Multi-table Reports
- ✅ Implemented Audit Triggers
- ✅ Automated Visit History

### 🎯 Learning Outcomes

- Write complex JOIN queries
- Create reusable stored procedures
- Automate database operations
- Implement auditing and business rules

---

# 📚 Day 4 – JDBC & MySQL Integration

> **Project:** Health Clinic Management System

### 🚀 Topics Covered

#### ☕ JDBC Fundamentals
- JDBC Architecture
- DriverManager & Connection
- PreparedStatement
- ResultSet Mapping
- Exception Handling

#### 🏗️ Backend Architecture
- Layered Architecture
- DAO Pattern
- DTO Pattern
- Service Layer
- Console-Based Application

#### 🔄 Database Operations
- CRUD Operations
- Transaction Management
- Commit & Rollback
- Auto Generated Keys
- Try-With-Resources

### 💻 Practical Session

- ✅ Built Layered Health Clinic Application
- ✅ Implemented DAO & DTO Patterns
- ✅ Performed CRUD Operations
- ✅ Integrated Java with MySQL
- ✅ Implemented Transactions
- ✅ Developed Console-Based Menu System

### 🎯 Learning Outcomes

- Connect Java applications with MySQL
- Implement CRUD using JDBC
- Apply DAO & DTO design patterns
- Manage database transactions
- Develop modular backend applications

---

# 📚 Day 5 – Java Servlet Fundamentals
> **Project:** Greeting Web Application

### 🚀 Topics Covered
- Servlet Lifecycle & Architecture
- Apache Tomcat Setup
- Maven Web Application
- HTTP (GET/POST), Forms

### 💻 Practical
- ✅ Built Servlet-based Web App  
- ✅ Form Handling  
- ✅ Deployment & Debugging  

### 🎯 Outcome
- Built and deployed Java web applications using Servlets

---

# 📚 Day 6 – Spring MVC & CRUD Operations
> **Project:** Spring MVC Application

### 🚀 Topics Covered

#### 🌱 Spring MVC
- Model, View & Controller
- `DispatcherServlet`
- Request-Response Flow
- Servlet vs Spring MVC

#### ⚙️ Spring Boot
- Spring Boot Maven Project
- `spring-boot-starter-web`
- Embedded Tomcat
- Java 21 Configuration

#### 🏗️ Architecture
```text
Client
   ↓
DispatcherServlet
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

### 💻 Practical
- ✅ Created Spring Boot MVC Application
- ✅ Implemented Layered Architecture
- ✅ Developed CRUD Operations
- ✅ Configured Controllers, Services & Repository

### 🎯 Outcome
Learned to build **layered CRUD applications using Spring Boot and Spring MVC**.

---

# 📚 Day 7 – Contact Management REST API
> **Project:** Contact Management API

### 🚀 Topics Covered

- REST API Fundamentals
- Spring Web
- Layered Architecture
- DTO Pattern
- Service Interface & Implementation
- Spring Data JPA
- Entity & Repository
- Lombok
- Jakarta Validation
- H2 Database

### 🏗️ Architecture

```text
Client
   ↓
Controller
   ↓
DTO
   ↓
Service Interface
   ↓
Service Implementation
   ↓
Repository
   ↓
Entity
   ↓
H2 Database
```

### 💻 Practical

- ✅ Created Spring Boot REST API
- ✅ Implemented Contact Entity
- ✅ Created Request & Response DTOs
- ✅ Implemented Service Layer
- ✅ Created JPA Repository
- ✅ Configured H2 Database
- ✅ Added Validation
- ✅ Implemented Create Contact API
- ✅ Implemented Get All Contacts API

### 🎯 Outcome

Built a basic **RESTful Contact Management API** using Spring Boot and learned how different backend layers work together to process API requests.

---

# 🛠️ Tech Stack

| Category | Technologies |
|----------|--------------|
| 💻 Language | Java 21 |
| 🗄️ Database | MySQL, H2 |
| 📝 Query Language | SQL |
| 🔌 Database Access | JDBC, JPA |
| 🌱 Framework | Spring Boot, Spring MVC |
| 🌐 Web | Servlets, REST API |
| 📦 ORM | Spring Data JPA |
| 🛡️ Validation | Jakarta Validation |
| ✨ Utility | Lombok |
| 🚀 Server | Apache Tomcat |
| 🔨 Build Tool | Maven |
| 🧰 Tools | IntelliJ IDEA, Git, GitHub |

---

# 🎯 Skills Gained

- DBMS & SQL
- Relational Database Design
- Database Normalization
- SQL Joins
- Stored Procedures & Triggers
- Indexing & Query Optimization
- JDBC
- DAO & DTO Patterns
- Layered Architecture
- Transaction Management
- Java Servlets
- Spring MVC
- Spring Boot
- REST API Development
- Spring Data JPA
- Entity & Repository Design
- Request & Response DTOs
- Validation
- H2 Database

---

## 📈 Training Progress

| Day | Module | Status |
|------|--------|:------:|
| ✅ Day 1 | DBMS & SQL Fundamentals | ✔️ |
| ✅ Day 2 | Database Design & Optimization | ✔️ |
| ✅ Day 3 | Joins, Procedures & Triggers | ✔️ |
| ✅ Day 4 | JDBC & MySQL Integration | ✔️ |
| ✅ Day 5 | Java Servlet Fundamentals | ✔️ |
| ✅ Day 6 | Spring MVC & CRUD Operations | ✔️ |
| ✅ Day 7 | Contact Management REST API | ✔️ |

---

<div align="center">

## 🏆 Training Progress

### **7 / 20 Days Completed**

**DBMS → SQL → JDBC → Servlets → Spring MVC → REST API**

⭐ **Learning • Building • Improving Every Day** ⭐

</div>