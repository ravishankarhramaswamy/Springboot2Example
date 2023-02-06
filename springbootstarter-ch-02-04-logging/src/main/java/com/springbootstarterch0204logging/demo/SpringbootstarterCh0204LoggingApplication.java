package com.springbootstarterch0204logging.demo;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class SpringbootstarterCh0204LoggingApplication {
	
	private static Logger logger = (Logger) LoggerFactory.getLogger(SpringbootstarterCh0204LoggingApplication.class);

	public static void main(String[] args) {
		var ctx = SpringApplication.run(SpringbootstarterCh0204LoggingApplication.class, args);
		
		//System.out.println("# Beans : " + ctx.getBeanDefinitionCount());
		logger.debug("# Beans : " + ctx.getBeanDefinitionCount());
		
		var names = ctx.getBeanDefinitionNames();
		
		Arrays.sort(names);
		Arrays.asList(names).forEach(logger::debug);
	}

}
