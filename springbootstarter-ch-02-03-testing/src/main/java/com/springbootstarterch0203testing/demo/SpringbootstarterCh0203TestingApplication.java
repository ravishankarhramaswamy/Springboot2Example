package com.springbootstarterch0203testing.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springbootstarterch0203testing.demo.bean.Calculator;

@SpringBootApplication
public class SpringbootstarterCh0203TestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstarterCh0203TestingApplication.class, args);
	}

	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator, @Value("${lhs}") int lhs, @Value("${rhs}") int rhs, @Value("${op}") char op) {
		return args -> calculator.calculate(lhs, rhs, op);
	}
}
