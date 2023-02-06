package com.springbootstarterch0101.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootstarterCh0101Application {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringbootstarterCh0101Application.class, args);
		
		System.out.println("# Beans : " + ctx.getBeanDefinitionCount());
		
		var names = ctx.getBeanDefinitionNames();
		
		Arrays.sort(names);
		Arrays.asList(names).forEach(System.out::println);
	}

}
