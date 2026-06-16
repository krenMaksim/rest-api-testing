package com.kren.rest.api.testing;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;

class JsonplaceholderTest {

    @Test
    void getPosts() {
        System.out.println(get("https://jsonplaceholder.typicode.com/posts").body()
                .asString());

    }

}
