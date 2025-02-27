package com.valtech.training.first;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
	
//	@Bean
	public SimpleInterest simpleInterest(Arithmetic arithmetic) {
		return new SimpleInterestImpl();
	}

//	@Bean
	public Arithmetic arithmetic() {
		return new ArithmeticImpl();
	}
}
