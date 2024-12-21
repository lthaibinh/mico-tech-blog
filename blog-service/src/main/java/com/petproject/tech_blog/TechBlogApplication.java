package com.petproject.tech_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
public class TechBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechBlogApplication.class, args);
	}

}
