# Spring Boot API Security Project

## Objective
Implement security measures to secure APIs in a Spring Boot application, including authentication, authorization, and role-based access control.

## Table of Contents
- [Objective](#objective)
- [Features](#features)
- [Project Setup](#project-setup)
- [Configuring Spring Security](#configuring-spring-security)
- [Implementing OAuth2 and JWT Integration](#implementing-oauth2-and-jwt-integration)
- [Role-Based Access Control (RBAC)](#role-based-access-control-rbac)
- [Testing the Application](#testing-the-application)
- [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
- [Testing with Postman](#testing-with-postman)
- [Submission](#submission)

## Features
- Basic Authentication setup using Spring Security.
- OAuth2 and JWT integration for secure token-based authentication.
- Role-Based Access Control (RBAC) with roles like ADMIN and USER.
- Secure endpoints with method-level security using Spring Security annotations.

## Project Setup

### Setting up the Project
1. **Create a new Spring Boot Project:**
    - Use [Spring Initializr](https://start.spring.io/) to generate a new Spring Boot project.
    - **Dependencies:**
        - Spring Web
        - Spring Security
        - Spring Boot DevTools (optional but recommended for development)

2. **Project Structure:**
    - Organize the project with the following packages:
        - `controllers`: For API endpoints
        - `services`: For business logic and service layer
        - `models`: For entities and data transfer objects (DTOs)
        - `security`: For security configuration, JWT utility, and user details service
        - `repositories`: For data access layers like user repository

### Configuring Spring Security for Basic Authentication
1. **Security Configuration:**
    - Create a `SecurityConfig` class annotated with `@Configuration`.
    - Extend `WebSecurityConfigurerAdapter` and override `configure(HttpSecurity http)` to set up security settings.
    - Configure authentication using either an in-memory user store or a custom user details service.

### Implementing OAuth2 and JWT Integration
1. **Dependencies:**
    - Add dependencies for Spring Security OAuth2 and JWT in your `pom.xml`:
      ```xml
      <dependencies>
          <!-- Spring Security OAuth2 -->
          <dependency>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-starter-oauth2-client</artifactId>
          </dependency>
          <!-- JWT Dependencies -->
          <dependency>
              <groupId>io.jsonwebtoken</groupId>
              <artifactId>jjwt-api</artifactId>
              <version>0.11.5</version>
          </dependency>
          <dependency>
              <groupId>io.jsonwebtoken</groupId>
              <artifactId>jjwt-impl</artifactId>
              <version>0.11.5</version>
              <scope>runtime</scope>
          </dependency>
          <dependency>
              <groupId>io.jsonwebtoken</groupId>
              <artifactId>jjwt-jackson</artifactId>
              <version>0.11.5</version>
              <scope>runtime</scope>
          </dependency>
      </dependencies>
      ```

2. **OAuth2 and JWT Configuration:**
    - Create `OAuth2Config.java` for OAuth2 client and server settings.
    - Implement JWT generation and validation in `JwtTokenUtil.java`.
    - Create a custom `JwtUserDetailsService` for loading user data.

3. **Endpoints:**
    - `/api/register`: User registration
    - `/api/login`: User login to get JWT token
    - `/api/token`: Manually generate a JWT token

### Role-Based Access Control (RBAC)
1. **Define Roles:**
    - Define roles such as ADMIN and USER and assign authorities.

2. **Method-Level Security:**
    - Use annotations like `@PreAuthorize` and `@Secured` in your controllers or services to secure endpoints based on roles.

### Testing the Application
- Use Postman or any other API testing tool to test the API endpoints.
- Ensure authentication, authorization, and RBAC are functioning correctly by accessing endpoints with different roles.

## Running the Application
1. **Clone the Repository:**
   ```bash
   git clone <repository-url>
   cd <project-directory>
