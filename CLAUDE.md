# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project overview

A learning/exploration project for REST API testing with REST-assured. It contains two distinct test types:

1. **Live API tests** — hit `https://jsonplaceholder.typicode.com` directly using `io.restassured.RestAssured`
2. **Spring MockMVC tests** — test the local `GreetingRest` controller without a running server using `RestAssuredMockMvc`

The production code (`src/main/`) is a minimal Spring Boot app with a single `GreetingRest` controller. The bulk of the work lives in `src/test/`.

## Build and test commands

```bash
# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=PostsTest

# Run a single test method
mvn test -Dtest=GreetingRestTest#greeting
```

Tests tagged `slow` are excluded by default (surefire config in `pom.xml`).

## Code style

Use IntelliJ IDEA's default Java formatter for all code changes.

## Test architecture patterns

**MockMVC tests** (`GreetingRestTest`) — annotated with `@SpringBootTest`. Call `RestAssuredMockMvc.webAppContextSetup(wac)` in `@BeforeEach` and `RestAssuredMockMvc.reset()` in `@AfterEach`.

**JSON Schema files** live in `src/test/resources/` and are referenced by filename (e.g., `matchesJsonSchemaInClasspath("greeting.json")`).
