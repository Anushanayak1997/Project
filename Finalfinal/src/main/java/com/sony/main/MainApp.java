package com.sony.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.sony.controller","com.sony.model.service", "com.sony.dao"})

// @EnableJpaRepositories(basePackages = {"com.sony.dao"})
public class MainApp {
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

}
