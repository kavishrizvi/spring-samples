# Java Spring Sample Implementations

---

## Overview

This repository is a **collection of focused Spring Boot implementations** covering common backend patterns and production concerns.

Each module is:
- Small and isolated
- Built with a clear purpose
- Designed to demonstrate *how things actually work in real systems*

No fluff. Just working code with intent.

---

## Existing Implementations

### 1. Circuit Breaker Pattern using Hystrix (Legacy)
- Demonstrates fault tolerance using Hystrix
- Covers fallback, timeout, and circuit behavior
- Includes dashboard monitoring

👉 [View README](./circuit-breaker-using-hystrix/README.md)

---

### 2. Config Client / Server
- Centralized configuration using Spring Cloud Config
- Externalized properties management

👉 [View README](./config-client-server/README.md)

---

### 3. ELK Logging Framework Implementation
- Centralized logging using Elasticsearch, Logstash, Kibana
- Structured logs for observability

👉 [View README](./elk-logging/README.md)

---

### 4. Eureka Server / Client
- Service discovery using Netflix Eureka
- Dynamic service registration and lookup

👉 [View README](./eureka-server-client/README.md)

---

### 5. HATEOAS
- Hypermedia-driven REST APIs
- Adds discoverability to endpoints

👉 [View README](./hateoas/README.md)

---

### 6. Kafka Publisher / Consumer
- Event-driven architecture using Kafka
- Producer and consumer setup

👉 [View README](./kafka-pub-sub/README.md)

---

### 7. OAuth2 Security
- Authentication and authorization using OAuth2
- Token-based security model

👉 [View README](./oauth2-security/README.md)

---

### 8. Redis Cache Implementation
- In-memory caching using Redis
- Improves performance and reduces DB load

👉 [View README](./redis-cache/README.md)

---

### 9. Spring AOP Weaving
- Cross-cutting concerns using AOP
- Logging, auditing, etc.

👉 [View README](./spring-aop/README.md)

---

### 10. Controller Advice
- Global exception handling
- Clean API error responses

👉 [View README](./controller-advice/README.md)

---

### 11. Spring Boot + Hibernate + JPA + PostgreSQL
- Full persistence stack
- ORM with relational DB

👉 [View README](./spring-boot-jpa-postgresql/README.md)

---

### 12. Spring Data JPA
- Simplified repository abstraction
- Query generation and custom queries

👉 [View README](./spring-data-jpa/README.md)

---

### 13. Spring OpenAI
- Integration with OpenAI APIs
- AI-driven features in Spring apps

👉 [View README](./spring-openai/README.md)

---

### 14. Spring Security
- Core Spring Security concepts
- Authentication and authorization flows

👉 [View README](./spring-security/README.md)

---

## Upcoming Implementations

### 1. Circuit Breaker Pattern using Resilience4j
- Modern replacement for Hystrix
- Lightweight and actively maintained

👉 (Coming soon)

---

### 2. Spring Boot + MongoDB
- NoSQL integration
- Document-based persistence

👉 (Coming soon)

---

### 3. JWT Implementation using Spring Security
- Stateless authentication
- Token-based security

👉 (Coming soon)

---

### 4. GraphQL with Spring Boot
- Flexible query-based APIs
- Alternative to REST

👉 (Coming soon)

---

## Structure

Each module follows:
- `controller` → API layer
- `service` → business logic
- `config` → configuration
- `resources` → properties

---

## How to Use

1. Clone the repo
2. Navigate to a module
3. Run:
   ```bash
   mvn spring-boot:run
4. Use Postman or curl to test APIs   