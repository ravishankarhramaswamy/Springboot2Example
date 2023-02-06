package com.springbootstarterch0308springmvcssl.demo.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springbootstarterch0308springmvcssl.demo.library.CustomizedErrorAttributes;

@Configuration
public class ErrorConfig {

	@Bean
	public CustomizedErrorAttributes errorAttributes() {
		return new CustomizedErrorAttributes();
	}

}
