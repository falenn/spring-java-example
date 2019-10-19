package org.talents.examples.springjava.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.talents.examples.springjava.App;
import org.talents.examples.springjava.beans.TestBean;

@Configuration
public class AppConfig {

	
	@Value("${serviceName:NA}")
	private String serviceName;
	
	@Bean
	TestBean testBean() {
		return new TestBean();
	}
	
	@Bean
	App appBean() {
		return new App();
	}
}
