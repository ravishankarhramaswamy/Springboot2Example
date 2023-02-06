package com.springbootstarterch0102.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootstarterCh0102Application {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringbootstarterCh0102Application.class, args);
		
		System.out.println("# Beans : " + ctx.getBeanDefinitionCount());
		
		var names = ctx.getBeanDefinitionNames();
		
		Arrays.sort(names);
		Arrays.asList(names).forEach(System.out::println);
	}

}
