package com.kren.rest.api.testing.rest;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class GreetingRestTest {

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    public void configureMockMvcInstance() {
        RestAssuredMockMvc.webAppContextSetup(wac);
    }

    @AfterEach
    public void restRestAssured() {
        RestAssuredMockMvc.reset();
    }

    @Test
    void greeting() {
        standaloneSetup(new GreetingRest());

        given().param("name", "Johan")
                .when()
                .get("/greeting")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("content", equalTo("Hello, Johan!"));
    }

    @Test
    void greetingJson() {
        standaloneSetup(new GreetingRest());

        given().param("name", "Johan")
                .when()
                .get("/greeting")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("greeting.json"));
    }
}
