package com.demo.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculateTest {

	private Calculate cal;

	// If Calculate class then init it in BeforeAll otherwise use BeforeEach

	@BeforeEach
	public void intiCalculate() {
		cal = new Calculate();
	}

	@AfterEach
	public void disposeCalculate() {
		cal = null;
	}

	@Test
	public void addTest() {
		assertEquals(5, cal.add(3, 2));
	}

	@Test
	public void subTest() {
		assertEquals(1, cal.sub(3, 2));
	}

	@Test
	public void mulTest() {
		Assertions.assertEquals(6, cal.mul(3, 2));
	}

}
