package com.sony.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sony.controller","com.sony.model.service", "com.sony.dao"})

// @EnableJpaRepositories(basePackages = {"com.sony.dao"})
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

}
