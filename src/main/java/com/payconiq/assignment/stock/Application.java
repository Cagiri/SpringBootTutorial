package com.payconiq.assignment.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				SpringApplication.run(Application.class, args);
		
		
		if (logger.isTraceEnabled()) {
			for (String name : applicationContext.getBeanDefinitionNames()) {
				System.out.println(name);
			}	
		}
	}
}
