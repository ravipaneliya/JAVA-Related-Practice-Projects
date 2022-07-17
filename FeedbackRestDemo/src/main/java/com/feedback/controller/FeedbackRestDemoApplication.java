package com.feedback.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.feedback")
public class FeedbackRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackRestDemoApplication.class, args);
	}

}
