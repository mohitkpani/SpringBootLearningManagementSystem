# 📚 Course Management System

A simple **Course Management System** built using **Spring Boot, Java, MySQL, HTML, CSS, and JavaScript**.

The application provides REST APIs for managing courses and a simple frontend to interact with those APIs.

---

## 🚀 Features

- ✅ Add a new course
- ✅ View all courses
- ✅ Find course by ID
- ✅ Update course completely
- ✅ Update course partially
- ✅ Delete course
- ✅ Input validation
- ✅ Global exception handling
- ✅ RESTful APIs
- ✅ Simple nature-themed frontend
- ✅ Profile section
- ✅ Responsive design

---

## 🛠️ Technologies Used

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Jakarta Validation
- Maven

### Database

- MySQL

### Frontend

- HTML5
- CSS3
- JavaScript
- Fetch API

---

## 📁 Project Structure

```text
cms
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.lms.cms
│   │   │       │
│   │   │       ├── controller
│   │   │       │   └── CourseController.java
│   │   │       │
│   │   │       ├── dto
│   │   │       │   ├── CourseRequestDTO.java
│   │   │       │   └── CourseResponseDTO.java
│   │   │       │
│   │   │       ├── entity
│   │   │       │   └── Course.java
│   │   │       │
│   │   │       ├── exception
│   │   │       │   ├── CourseNotFoundException.java
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       │
│   │   │       ├── repository
│   │   │       │   └── CourseRepository.java
│   │   │       │
│   │   │       └── service
│   │   │           └── CourseService.java
│   │   │
│   │   └── resources
│   │       │
│   │       ├── static
│   │       │   ├── index.html
│   │       │   │
│   │       │   ├── css
│   │       │   │   └── style.css
│   │       │   │
│   │       │   ├── js
│   │       │   │   └── script.js
│   │       │   │
│   │       │   └── images
│   │       │       └── profile.jpg
│   │       │
│   │       └── application.properties
│   │
│   └── test
│
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
