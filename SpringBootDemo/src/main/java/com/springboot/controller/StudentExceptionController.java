package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springboot.demo.StudentNotFoundException;

@ControllerAdvice
public class StudentExceptionController {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<Object> hanldeException(StudentNotFoundException ex){
		return new ResponseEntity<Object>("Student not available with Id 0",HttpStatus.NOT_FOUND);
	}
}
