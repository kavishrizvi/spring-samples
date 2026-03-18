# Circuit Breaker with Hystrix

## Overview

This project demonstrates a **circuit breaker pattern using Hystrix** in a Spring Boot application.  
The goal is simple: **protect your service from downstream failures** and avoid cascading outages.

---

## Key Concepts

- We call an external service (`ms-users`)
- If it fails or becomes slow → **Hystrix trips the circuit**
- Instead of failing the request → we return a **fallback response**

---

# Annotations Explained

## `@SpringBootApplication`
- Entry point of the Spring Boot app
- Combines:
    - `@Configuration`
    - `@EnableAutoConfiguration`
    - `@ComponentScan`
- Bootstraps everything automatically

---

## `@EnableCircuitBreaker`
- Enables circuit breaker support in the app
- Required for Hystrix to intercept method calls

---

## `@EnableHystrixDashboard`
- Enables Hystrix monitoring dashboard
- Useful to visualize:
    - failures
    - latency
    - circuit state (open/closed)

---

## `@Configuration`
- Marks a class that defines Spring beans
- Used to configure objects manually

---

## `@Bean`
- Registers a method return value as a Spring-managed bean
- Here:
    - We create a `RestTemplate` with timeout config

---

## `@RestController`
- Combines:
    - `@Controller`
    - `@ResponseBody`
- Exposes REST endpoints

---

## `@RequestMapping`
- Defines base URL for the controller

---

## `@GetMapping`
- Maps HTTP GET requests to a method

---

## `@Service`
- Marks business logic layer
- Spring manages lifecycle and dependency injection

---

## `@Value`
- Injects values from `application.yml`
- Used for:
    - host
    - port
    - API path

---

## `@HystrixCommand`
- Core of circuit breaker
- Wraps method execution

### What it does:
- Monitors execution time
- Tracks failures
- Opens circuit if threshold exceeded
- Calls fallback when needed

---

## `fallbackMethod`
- Method to call when:
    - exception occurs
    - timeout happens
    - circuit is open

---

## `@HystrixProperty`
- Used to tune circuit breaker behavior

### Important ones used:

| Property | Meaning |
|----------|--------|
| `execution.isolation.thread.timeoutInMilliseconds` | Max time before timeout |
| `circuitBreaker.requestVolumeThreshold` | Min requests before CB evaluates |
| `circuitBreaker.errorThresholdPercentage` | % failures to open circuit |
| `circuitBreaker.sleepWindowInMilliseconds` | Time before retry |

---

# What We Improved and Why

## 1. Fixed Wrong HTTP Headers
**Problem**
- Used `com.sun.net.httpserver.Headers` (incorrect)

**Fix**
- Replaced with `HttpHeaders`

**Why**
- Spring expects its own HTTP abstraction
- Prevents runtime issues

---

## 2. Added Timeouts to RestTemplate
```java
factory.setConnectTimeout(2000);
factory.setReadTimeout(3000);