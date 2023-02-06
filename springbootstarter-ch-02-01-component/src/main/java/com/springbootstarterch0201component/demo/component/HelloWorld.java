package com.springbootstarterch0201component.demo.component;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class HelloWorld {
	
	@PostConstruct
	public void sayhello() {
		System.out.println("Hello World, from SpringBoot 2!");
	}

}
