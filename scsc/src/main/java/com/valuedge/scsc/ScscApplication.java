package com.valuedge.scsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

//@EnableJpaRepositories(basePackages = "com.valuedge.scsc.repositories")
@SpringBootApplication
//@EntityScan(basePackages = {"com.valuedge.scsc.entities"})
@EnableMBeanExport(registration=RegistrationPolicy.IGNORE_EXISTING)
public class ScscApplication extends SpringBootServletInitializer{

	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(ScscApplication.class);
	    }
	 
	public static void main(String[] args) {
		SpringApplication.run(ScscApplication.class, args);
	}
}
