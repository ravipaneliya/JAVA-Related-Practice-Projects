package com.prototype.JUnitDemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class TestAuth {

	UserAuth userAuth;

	@BeforeEach
	public void beforeEach() {
		userAuth = new UserAuth();
		System.out.println("------------ Before Each ------------");
	}

	@AfterEach
	public void afterEach() {
		userAuth = null;
		System.out.println("------------ After  Each ------------\n");
	}

	@Test
	public void testBlank() {
		assertFalse(userAuth.authUser("", ""));
		System.out.println("testBlank");
	}

	@Test
	public void testNull() {
		System.out.println("testNull");
		if (userAuth.authUser(null, null)) {
			fail();
		}
	}

	@Test
	public void testWrongUser() {
		System.out.println("testWrongUser");
		if (userAuth.authUser("testing", "pwd")){
			fail();
		}
	}

	@Test
	public void testWrongPass() {
		System.out.println("testWrongPass");
		assertFalse(userAuth.authUser("test", "pass"));
	}

	@Test
	public void testBothWrong() {
		System.out.println("testBothWrong");
		assertFalse(userAuth.authUser("testing", "pass"));
	}

	@Test
	@DisplayName("Valid User Password Test Case")
	public void testCorrect() {
		System.out.println("testCorrect");
		assertTrue(userAuth.authUser("test", "pwd"));
	}
}
