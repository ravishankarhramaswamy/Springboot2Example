package com.springbootstarterch0401springasyncrequesthandling.demo.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControllerUsingCallable {
	@GetMapping("/helloUsingCallable")
	public Callable<String> helloUsingCallable() {
		return () -> {
			Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
			return "Hello World, from Spring Boot 2 Using Callable!";
		};
	}
}
