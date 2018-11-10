package com.kren.rest.api.testing.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRest {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
	System.out.println("tes");

	return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    static class Greeting {
	private final long id;
	private final String content;

	public Greeting(long id, String content) {
	    this.id = id;
	    this.content = content;
	}

	public long getId() {
	    return id;
	}

	public String getContent() {
	    return content;
	}
    }
}
