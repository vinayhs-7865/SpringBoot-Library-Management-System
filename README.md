# 📚 Library Management System (Spring Boot)

## 📖 Introduction
The **Library Management System** is a web-based application built with **Spring Boot** that helps manage library operations such as handling books, students, librarians, and transaction records. It provides a simple and efficient interface for both librarians and students.

---

## 🎯 Objectives
- Automate the management of books, students, and librarians.
- Maintain records of book issues and returns.
- Provide an intuitive dashboard for administrators.
- Ensure secure access through authentication and authorization.

---

## 🛠️ Tech Stack
- **Backend:** Spring Boot, Java  
- **Frontend:** HTML, CSS, Thymeleaf  
- **Database:** MySQL (or H2 for testing)  
- **Build Tool:** Maven  

---

## ⚙️ Features
- 🔑 Login and authentication system  
- 📊 Dashboard for quick navigation  
- 📚 Manage books (Add / Update / Delete)  
- 👨‍🎓 Manage students  
- 👨‍💼 Manage librarians  
- 📝 Track issued & returned books  
- 📄 View transaction records  

---

## 📂 Project Structure
Library-Management-System-Springboot
│── src/main/java/com/example/lms
│ ├── controller # Handles HTTP requests
│ ├── dto # Data Transfer Objects
│ ├── entity # JPA Entities
│ ├── repository # Data Access Layer
│ ├── service # Business Logic
│ └── LmsApplication.java
│
│── src/main/resources
│ ├── static # CSS, JS
│ ├── templates # Thymeleaf HTML pages
│ └── application.yml
│
│── pom.xml # Maven dependencies