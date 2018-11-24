
package com.kren.rest.api.testing.jsonplaceholder;

import static io.restassured.RestAssured.get;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.junit.jupiter.api.Test;

class PostsTest {

    @Test
    void getPosts() {
	get("https://jsonplaceholder.typicode.com/posts").then()
	                                                 .assertThat()
	                                                 .body(matchesJsonSchemaInClasspath("jsonplaceholder_posts.json"));
    }
}
