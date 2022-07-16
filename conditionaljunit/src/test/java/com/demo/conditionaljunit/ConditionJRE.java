package com.demo.conditionaljunit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

class ConditionJRE {

	@Test
	@EnabledOnJre(JRE.JAVA_8)
	public void runJava8() {
		System.out.println("Executing JAVA 8");
	}

	@Test
	@EnabledOnJre(JRE.JAVA_9)
	public void runJava9() {
		System.out.println("Executing JAVA 9");
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_10)
	public void runJava10() {
		System.out.println("Executing JAVA 10");
	}
	
	@Test
	@EnabledOnJre(JRE.JAVA_11)
	public void runJava11() {
		System.out.println("Executing JAVA 11");
	}

	@Test
	@EnabledOnJre(JRE.JAVA_17)
	public void runJava13() {
		System.out.println("Executing JAVA 18");
	}

}
