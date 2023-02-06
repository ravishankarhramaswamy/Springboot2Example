package com.springbootstarterch0201bean.demo;

import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springbootstarterch0201bean.demo.bean.Calculator;
import com.springbootstarterch0201bean.demo.bean.service.Operation;
import com.springbootstarterch0201bean.demo.bean.service.impl.Addition;
import com.springbootstarterch0201bean.demo.bean.service.impl.Division;
import com.springbootstarterch0201bean.demo.bean.service.impl.Multiplication;
import com.springbootstarterch0201bean.demo.bean.service.impl.Subtraction;

@SpringBootApplication
public class SpringbootstarterCh0201BeanApplication {

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringbootstarterCh0201BeanApplication.class, args);
		
		var calculator = ctx.getBean(Calculator.class);
		calculator.calculate(137, 21, '+');
		calculator.calculate(137, 21, '-');
		calculator.calculate(137, 21, '*');
		calculator.calculate(137, 21, '/');
	}

	@Bean
	public Calculator calculator(Collection<Operation> operations) {
		return new Calculator(operations);
	}
	
	@Bean
	public Addition addition() {
		return new Addition();
	}
	
	@Bean
	public Multiplication multiplication() {
		return new Multiplication();
	}
	
	@Bean
	public Subtraction subtraction() {
		return new Subtraction();
	}
	
	@Bean
	public Division division() {
		return new Division();
	}
}
