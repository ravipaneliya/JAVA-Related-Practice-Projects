package com.demo.junittest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAllMethods {

	@BeforeAll
	public static void beforeAll() {
		System.out.println("\n=====: BeforeAll Executed :=====");
	}
	
	@BeforeEach
	public void beforeEach() {
		System.out.println("\nbeforeEach Executed");
	}
	
	@Test
	public void testCaseOne() {
		System.out.println("\ntestCaseOne Executed");
	}

	@Test
	public void testCaseTwo() {
		System.out.println("\ntestCaseTwo Executed");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("\nafterEach Executed");
	}
	
	@AfterAll
	public static void afterAll() {
		System.out.println("\n=====: AfterAll Executed :=====");
	}
}
