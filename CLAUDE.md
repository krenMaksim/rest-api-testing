# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project overview

A learning/exploration project for REST API testing with REST-assured. It contains two distinct test types:

1. **Live API tests** — hit `https://jsonplaceholder.typicode.com` directly using `io.restassured.RestAssured`
2. **Spring MockMVC tests** — test the local `GreetingRest` controller without a running server using `RestAssuredMockMvc`

The production code (`src/main/`) is minimal — just a Spring MVC `GreetingRest` controller that serves as the subject under test for the MockMVC tests. The bulk of the work lives in `src/test/`.

## Build and test commands

```bash
# Build (skipping tests)
mvn clean package -DskipTests

# Run all tests
mvn test

# Run a single test class
mvn test -Dtest=PostsTest

# Run a single test method
mvn test -Dtest=GreetingRestTest#greeting
```

Tests tagged `slow` are excluded by default (surefire config in `pom.xml`).

## Key dependencies

| Dependency | Purpose |
|---|---|
| `io.rest-assured:rest-assured` | HTTP client DSL for live API tests |
| `io.rest-assured:spring-mock-mvc` | REST-assured adapter for Spring MockMVC |
| `io.rest-assured:json-schema-validator` | JSON Schema validation via `matchesJsonSchemaInClasspath()` |
| `org.springframework:spring-webmvc` + `spring-test` | Spring context for MockMVC tests |
| JUnit 5 (`junit-jupiter-*`) | Test runner; Surefire uses `junit-platform-surefire-provider` |

## Test architecture patterns

**MockMVC tests** (`GreetingRestTest`) — use `@ExtendWith(SpringExtension.class)` + `@ContextConfiguration(classes = {WebConfig.class})` + `@WebAppConfiguration`. Call `RestAssuredMockMvc.webAppContextSetup(wac)` in `@BeforeEach` and `RestAssuredMockMvc.reset()` in `@AfterEach`.

**JSON Schema files** live in `src/test/resources/` and are referenced by filename (e.g., `matchesJsonSchemaInClasspath("greeting.json")`).

## Packaging

The project packages as a WAR (`<packaging>war</packaging>`). `AppInitializer` is the `WebApplicationInitializer` that replaces `web.xml`. The WAR is not the focus — tests are.
