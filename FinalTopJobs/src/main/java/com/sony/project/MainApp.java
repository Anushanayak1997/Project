package com.sony.project;
 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
//@ComponentScan(basePackages={"com.sony.project.controllers","com.sony.project.services", "com.sony.project.dao"})
//@EnableJpaRepositories
public class MainApp {
 
	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

}
