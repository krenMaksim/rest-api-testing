
package com.kren.rest.api.testing;

import static io.restassured.RestAssured.get;

import org.junit.jupiter.api.Test;

class JsonplaceholderTest {

    @Test
    void getPosts() {
	System.out.println(get("https://jsonplaceholder.typicode.com/posts").body()
	                                                                    .asString());

    }

}
