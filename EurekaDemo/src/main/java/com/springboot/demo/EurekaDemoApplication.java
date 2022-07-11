package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDemoApplication {

	public static void main(String[] args) {
		// Create prject with WEB & Eureka dependency 
		// Add @EnableEurekaServer annotation
		// Add values in application.properties file
		// Run this file as Java App and open localhost:8081
		SpringApplication.run(EurekaDemoApplication.class, args);
	}

}
