# Full Stack Employee Management System

**Angular | Spring Boot | MySQL**

## Overview

The **Employee Management System (EMS)** is a full-stack web application designed to simplify the management of employee data within an organization. It provides administrators with a structured interface to perform essential operations such as creating, viewing, updating, and deleting employee records.

The application follows a **client–server architecture**, where the Angular frontend communicates with a Spring Boot backend through RESTful APIs, and data is stored in a MySQL database.

The goal of this project is to demonstrate a scalable full-stack architecture using modern development practices and technologies.

---

# Tech Stack

## Backend

* **Java**
* **Spring Boot** – Handles server-side business logic and REST APIs
* **Spring Data JPA** – Simplifies database interactions
* **MySQL** – Relational database for persistent storage

## Frontend

* **Angular** – Component-based frontend framework
* **TypeScript**
* **HTML / CSS**

---

# Architecture

The system follows a **three-tier architecture**:

1. **Presentation Layer (Angular)**
   Responsible for rendering UI components and interacting with backend APIs.

2. **Application Layer (Spring Boot)**
   Contains business logic, service classes, and REST controllers.

3. **Data Layer (MySQL)**
   Stores employee information and ensures data consistency.

```
Angular Frontend
        |
        | REST API
        v
Spring Boot Backend
        |
        | JPA / Hibernate
        v
MySQL Database
```

---

# Features

## 1. Employee Directory

Displays a complete list of employees stored in the system.

* View employee details
* Organized table structure
* Easy navigation

<img src="Screenshots/Screenshot2.png" alt="Employee Directory" width="600"/>

---

## 2. Add Employee

Provides a form interface to add new employees to the system.

* Input validation
* Structured form fields
* Real-time feedback

<img src="Screenshots/Screenshot3.png" alt="Add Employee" width="600"/>

---

## 3. CRUD Operations

Supports complete employee lifecycle management.

* **Create** – Add new employee records
* **Read** – View employee details
* **Update** – Modify existing records
* **Delete** – Remove employees from the system

---

## 4. Validation System

Ensures data integrity by validating user inputs before submission.

Examples include:

* Required fields
* Data format validation
* Preventing incomplete records

---

## 5. Home Page

Acts as the primary entry point for the system and provides navigation to key features.

<img src="Screenshots/Screenshot1.png" alt="Home Page" width="600"/>

---

# Backend Implementation

The backend is implemented using **Spring Boot** and exposes REST APIs for the frontend application.

Key responsibilities include:

* Handling HTTP requests
* Processing business logic
* Managing database transactions
* Providing structured API responses

Spring Data JPA is used to simplify repository and database operations.

---

# Frontend Implementation

The frontend is built with **Angular** and follows a modular architecture.

Key characteristics:

* Component-based UI
* Reusable services
* Two-way data binding
* Responsive layout

The frontend communicates with the backend through HTTP services that consume REST endpoints.

---

# Project Setup

## Prerequisites

Ensure the following are installed:

* Java 17+
* Node.js
* Angular CLI
* MySQL
* Maven

---

## Backend Setup

```
cd backend
mvn clean install
mvn spring-boot:run
```

The backend server will start at:

```
http://localhost:8080
```

---

## Frontend Setup

```
cd frontend
npm install
ng serve
```

The frontend application will run at:

```
http://localhost:4200
```

---

# Future Improvements

Potential enhancements include:

* Authentication and role-based access control
* Pagination and advanced search
* Employee profile management
* API documentation with Swagger
* Docker-based deployment

---

# Conclusion

The Employee Management System demonstrates a practical implementation of a **modern full-stack application** using Angular, Spring Boot, and MySQL. The architecture supports maintainability, scalability, and clear separation of concerns, making it suitable as a foundation for enterprise workforce management systems.