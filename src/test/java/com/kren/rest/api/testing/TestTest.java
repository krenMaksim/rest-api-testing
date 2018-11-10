
package com.kren.rest.api.testing;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class TestTest {

    // @Test
    void t() {
	System.out.println("hello");

    }

    // @Test
    void t1() {
	get("/lotto").then()
	             .body("lotto.lottoId", equalTo(5));

    }

    @Test
    void t2() {

	System.out.println(get("https://jsonplaceholder.typicode.com/comments?postId=1").body()
	                                                                                .asString());

    }
}
