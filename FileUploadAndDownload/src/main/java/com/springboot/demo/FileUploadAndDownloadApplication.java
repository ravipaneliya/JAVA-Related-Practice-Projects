package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springboot.demo")
public class FileUploadAndDownloadApplication {

	public static void main(String[] args) {
		// Create springboot project with web dependency only
		// Configure annotations
		// Set application.properties for large file upload
		SpringApplication.run(FileUploadAndDownloadApplication.class, args);
	}

}
