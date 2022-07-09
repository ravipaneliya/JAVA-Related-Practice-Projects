package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.StudentNotFoundException;
import com.springboot.entity.Student;

@RestController
public class MainController {
	@RequestMapping("/hello")
	public String hello(){
		return "Welcome to Springboot App..";
	}
	
	@RequestMapping("/demodata")
	public ResponseEntity<Object> setResponse() {
		return new ResponseEntity<Object>(new Student(1, "SRP"), HttpStatus.FOUND);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable String id) {
		if(id == null || id.equals("0")) {
			throw new StudentNotFoundException("No Student available with 0 id");
		}
		return new ResponseEntity<Object>("Reuested for Student ID : " + id, HttpStatus.FOUND);
	}
}
