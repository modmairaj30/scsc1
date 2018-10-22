package com.valuedge.scsc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
 
	@Override
    public void addCorsMappings(CorsRegistry registry) {

		
		 
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
            .allowedHeaders("*") //
            .exposedHeaders("WWW-Authenticate") //
            .allowCredentials(true)
          // .allowedHeaders("header1", "header2", "header3")
         //   .exposedHeaders("header1", "header2")
            .allowCredentials(true).maxAge(3600);

        // Add more mappings...
    }
}
