package io.project.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.project.welcome.welcomeController;

@SpringBootApplication


@ComponentScan(basePackageClasses = welcomeController.class, basePackages={"io.project.topic"})
public class courseApiApp {

	public static void main(String[] args) {
		SpringApplication.run(courseApiApp.class, args); //start the execution from this class
	

	}

	
}
