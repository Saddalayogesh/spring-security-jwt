# Spring Security JWT Authentication

A secure REST API project built using Java, Spring Boot, Spring Security, JWT Authentication, MySQL, and JPA.

This project demonstrates authentication, authorization, role-based access control, and CRUD operations for products.

---

## 🚀 Features

- User Signup & Login
- JWT Authentication
- Role-Based Authorization
- Spring Security Configuration
- Product CRUD Operations
- MySQL Database Integration
- Password Encryption using BCrypt
- REST APIs
- Exception Handling
- Layered Architecture

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- ModelMapper

---

## 📂 Project Structure

```text
src/main/java
│
├── config
├── controller
├── dto
├── entity
├── enums
├── exception
├── repository
├── security
├── service
└── service impl
```

---

## ⚙️ Application Configuration

```yaml
spring:
  application:
    name: spring-security

  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/spring_security
    username: root
    password: your_password

  jpa:
    hibernate:
      ddl-auto: update

    show-sql: true

server:
  port: 8080
```

---

## 🗄️ Create Database

Run this query in MySQL before starting the project:

```sql
CREATE DATABASE spring_security;
```

---

## 🔐 Authentication APIs

### Signup

```http
POST /api/auth/signup
```

### Request Body

```json
{
  "name": "Yogesh",
  "email": "yogesh@gmail.com",
  "password": "123456"
}
```

---

### Login

```http
POST /api/auth/login
```

### Request Body

```json
{
  "email": "yogesh@gmail.com",
  "password": "123456"
}
```

---

## 📦 Product APIs

| Method | Endpoint | Access |
|--------|-----------|---------|
| GET | /api/products | CUSTOMER, ADMIN |
| POST | /api/products | ADMIN |
| PUT | /api/products/{id} | ADMIN |
| DELETE | /api/products/{id} | ADMIN |

---

## ▶️ Run the Project

Clone the repository:

```bash
git clone https://github.com/your-username/spring-security-jwt.git
```

Navigate to project folder:

```bash
cd spring-security-jwt
```

Run the project:

```bash
mvn spring-boot:run
```

---

## 🧪 Testing

Use:

- Postman
- Thunder Client

for testing APIs.

---

## 📌 Future Improvements

- Refresh Token Implementation
- Swagger Documentation
- Email Verification
- Docker Deployment
- Unit Testing

---

## 👨‍💻 Author

 *Yogesh*

