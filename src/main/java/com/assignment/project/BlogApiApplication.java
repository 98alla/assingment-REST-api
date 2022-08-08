package com.assignment.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
@EntityScan(basePackageClasses = { BlogApiApplication.class, Jsr310Converters.class })
public class BlogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

}
