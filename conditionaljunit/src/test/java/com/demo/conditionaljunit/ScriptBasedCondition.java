package com.demo.conditionaljunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.EnabledIf;

class ScriptBasedCondition {

	boolean trueCase() {
		return true;
	}
	
	boolean falseCase() {
		return false;
	}
	
	@Test
	@EnabledIf("trueCase")
	public void conditionTrue() {
		System.out.println("Executed when TRUE");
	}
	
	@Test
	@DisabledIf("falseCase")
	public void conditionFalse() {
		System.out.println("Executed when FALSE");
	}
}
