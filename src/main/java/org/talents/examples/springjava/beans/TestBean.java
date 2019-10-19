package org.talents.examples.springjava.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestBean {

	
	
	@Value("${serviceName:NA}")
	private String serviceName;
	
	
	public TestBean() {
		log.debug("TestBean created");
	}
	
	public String getServiceName() {
		return serviceName;
	}
}
