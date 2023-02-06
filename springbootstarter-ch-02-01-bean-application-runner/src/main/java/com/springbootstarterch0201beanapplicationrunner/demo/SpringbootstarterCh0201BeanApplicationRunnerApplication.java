package com.springbootstarterch0201beanapplicationrunner.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springbootstarterch0201beanapplicationrunner.demo.bean.Calculator;

@SpringBootApplication
public class SpringbootstarterCh0201BeanApplicationRunnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstarterCh0201BeanApplicationRunnerApplication.class, args);
	}

	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator) {
		return args -> {
			calculator.calculate(137, 21, '+');
			calculator.calculate(137, 21, '-');
			calculator.calculate(137, 21, '*');
			calculator.calculate(137, 21, '/');
		};
	}
}
