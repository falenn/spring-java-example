package org.talents.examples.springjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.stereotype.Component;
import org.talents.examples.springjava.beans.TestBean;

import lombok.extern.slf4j.Slf4j;

/**
 * This main provides an example for starting a spring app with commandline options WITHOUT using
 * springboot scaffolding.
 * 
 * @author curtisbates
 */
@Slf4j
@Component
public class App {

	@Autowired
	private TestBean testBean;
	
	public static void main(String[] args) {
		log.debug("Begin main");
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		SimpleCommandLinePropertySource clps = new SimpleCommandLinePropertySource(args);
		ctx.getEnvironment().getPropertySources().addFirst(clps);
		ctx.scan("org.talents.examples.springjava.config",
				 "org.talents.examples.springjava.beans",
				 "org.talents.examples.springjava");
		ctx.refresh();
		
		App app = ctx.getBean("appBean",App.class);
		log.debug("App Bean instantiation: " + app.testBean.getServiceName());
		
		TestBean bean = ctx.getBean("testBean",TestBean.class);
		log.debug("Config Bean instantiation: " + bean.getServiceName());	
	}
}
