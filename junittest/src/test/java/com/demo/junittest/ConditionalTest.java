package com.demo.junittest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class ConditionalTest {

	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void runOnWindows() {
		System.out.println("Runs on Windows");
	}
	
	@Test
	@DisabledOnOs({OS.MAC})
	public void notRunOnMac() {
		System.out.println("Not Runs on Mac");
	}
	
	@Test
	@EnabledOnOs({OS.MAC})
	public void runOnMac() {
		System.out.println("Runs on MAC");
	}
	
	@Test
	@EnabledOnOs({OS.LINUX})
	public void runOnLinux() {
		System.out.println("Runs on Linux");
	}

}
