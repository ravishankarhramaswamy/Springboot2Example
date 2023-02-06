package com.springbootstarterch0202externalizepropertiesconfigfile.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import com.springbootstarterch0202externalizepropertiesconfigfile.demo.bean.Calculator;

@PropertySource("classpath:myprops.properties")
@SpringBootApplication
public class SpringbootstarterCh0202ExternalizePropertiesConfigFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstarterCh0202ExternalizePropertiesConfigFileApplication.class, args);
	}

	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator, @Value("${lhs}") int lhs, @Value("${rhs}") int rhs, @Value("${op}") char op) {
		return args -> calculator.calculate(lhs, rhs, op);
	}
}
