package com.demo.junittest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Assertions {

	@Test
	void testAssertions() {
		assertTrue(15>7);
		assertFalse(15<7);
		
		assertNull(null);
		assertNotNull("");
		
		assertEquals(7, 5+2);
		assertNotEquals(7, 5+5);
		
		assertThrows(RuntimeException.class, ()->{throw new RuntimeException("Invalid");});
		
		assertThrows(NumberFormatException.class, ()->{throw new NumberFormatException("Not Valid Number");});
		
		
	}

}
