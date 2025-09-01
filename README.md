# Profile  Service

**Port:** 8091  

---

## Overview
`profile-service` manages customer/vendor profile operations for the Ecommerce platform.  
It allows updating user profile details.

It can also be extended with an get endpoint for ferching the entire profile details for a customer/vendor.

---

## Endpoints

| Endpoint                     | Method | Description                        |
|-------------------------------|--------|------------------------------------|
| /customer/v1/update/profile   | POST   | Update customer profile information |

---
## Configuration

Configuration file: src/main/resources/application*.properties or application.yml.

The application properties will be taken from the profile from https://github.com/mksandeep9875-stack/config-server-properties.git using spring cloud config server

---
## Dependencies

-Spring Boot Starter Web

-Spring Boot Starter Actuator

-Spring Boot Starter MongoDB (depending on your database)

-Spring Cloud Config Client

-Eureka Client


---

## How to Run

```bash
git clone <your-repo-url>
cd customer-service
mvn clean install
mvn spring-boot:run
