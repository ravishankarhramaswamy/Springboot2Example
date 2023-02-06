package com.springbootstarterch0202externalizeproperties.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springbootstarterch0202externalizeproperties.demo.bean.Calculator;

@SpringBootApplication
public class SpringbootstarterCh0202ExternalizePropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstarterCh0202ExternalizePropertiesApplication.class, args);
	}

	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator, @Value("${lhs}") int lhs, @Value("${rhs}") int rhs, @Value("${op}") char op) {
		return args -> calculator.calculate(lhs, rhs, op);
	}
}
