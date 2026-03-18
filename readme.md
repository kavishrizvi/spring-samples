# Java Spring Sample Implementations

---

## Overview

This repository contains a set of focused Spring Boot implementations covering common backend patterns used in production systems.

Each module is intentionally scoped to demonstrate a single concern:
- fault tolerance
- service discovery
- security
- messaging
- persistence
- observability

The code favors clarity over abstraction. The goal is to show how these patterns are wired and behave, not to hide them behind frameworks.

---

## Existing Implementations

### 1. Circuit Breaker Pattern using Hystrix (Legacy)
Implements circuit breaking using Hystrix. Covers timeouts, fallback handling, and basic dashboard monitoring.

[View README](./circuit-breaker-using-hystrix/README.md)

---

### 2. Config Client / Server
Centralized configuration using Spring Cloud Config. Demonstrates externalized configuration and runtime refresh.

[View README](./config-client-server/README.md)

---

### 3. ELK Logging Framework Implementation
Structured logging with ELK stack (Elasticsearch, Logstash, Kibana). Focus on log aggregation and analysis.

[View README](./elk-logging/README.md)

---

### 4. Eureka Server / Client
Service registration and discovery using Netflix Eureka. Covers client-side lookup and basic service resolution.

[View README](./eureka-server-client/README.md)

---

### 5. HATEOAS
Demonstrates hypermedia-driven REST APIs using Spring HATEOAS.

[View README](./hateoas/README.md)

---

### 6. Kafka Publisher / Consumer
Basic event-driven setup using Kafka. Includes producer and consumer flows.

[View README](./kafka-pub-sub/README.md)

---

### 7. OAuth2 Security
Authentication and authorization using OAuth2. Covers token-based access patterns.

[View README](./oauth2-security/README.md)

---

### 8. Redis Cache Implementation
Caching layer using Redis. Demonstrates cache usage patterns and performance impact.

[View README](./redis-cache/README.md)

---

### 9. Spring AOP Weaving
Aspect-oriented programming for cross-cutting concerns such as logging and tracing.

[View README](./spring-aop/README.md)

---

### 10. Controller Advice
Global exception handling using `@ControllerAdvice`. Standardizes API error responses.

[View README](./controller-advice/README.md)

---

### 11. Spring Boot + Hibernate + JPA + PostgreSQL
End-to-end persistence setup using Hibernate and PostgreSQL.

[View README](./spring-boot-jpa-postgresql/README.md)

---

### 12. Spring Data JPA
Repository abstraction and query handling using Spring Data JPA.

[View README](./spring-data-jpa/README.md)

---

### 13. Spring OpenAI
Integration with OpenAI APIs from a Spring Boot application.

[View README](./spring-openai/README.md)

---

### 14. Spring Security
Core Spring Security concepts including authentication and authorization.

[View README](./spring-security/README.md)

---

## Upcoming Implementations

### 1. Circuit Breaker Pattern using Resilience4j
Modern circuit breaker implementation replacing Hystrix.

---

### 2. Spring Boot + MongoDB
NoSQL persistence using MongoDB.

---

### 3. JWT Implementation using Spring Security
Stateless authentication using JWT.

---

### 4. GraphQL with Spring Boot
Graph-based API layer as an alternative to REST.

---
### 5. FeignClient with Spring Boot
Graph-based API layer as an alternative to REST.

---
### 6. Webclient with Spring Boot
Graph-based API layer as an alternative to REST.

---
### 7. gRPC with Spring Boot
Graph-based API layer as an alternative to REST.

---

## Structure

Each module follows a consistent layout:

- `controller` → API layer
- `service` → business logic
- `config` → configuration
- `resources` → application configuration

---

## Usage

From any module:

```bash
mvn spring-boot:run
```
Invoke APIs using Postman or curl.