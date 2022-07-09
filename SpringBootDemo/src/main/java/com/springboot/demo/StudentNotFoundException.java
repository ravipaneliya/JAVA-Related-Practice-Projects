package com.springboot.demo;

public class StudentNotFoundException extends RuntimeException{

	public StudentNotFoundException() {
		super();
	}
	public StudentNotFoundException(String mes) {
		super(mes);
	}
	@Override
	public String toString() {
		return "StudentNotFoundException "+ super.toString();
	}
	
}
