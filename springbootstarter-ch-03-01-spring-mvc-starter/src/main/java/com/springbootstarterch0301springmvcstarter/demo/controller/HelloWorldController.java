package com.springbootstarterch0301springmvcstarter.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello World, from Spring Boot 2!";
	}

}
