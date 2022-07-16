package com.demo.conditionaljunit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

class ConditionSystemProperty {

	@Test
	@EnabledIfSystemProperty(named = "os.version", matches = ".*10.*")
	public void runsOnWin10() {
		System.out.println("Executing Win10");
	}

	@Test
	@EnabledIfSystemProperty(named = "os.version", matches = ".*11.*")
	public void runsOnWin11() {
		System.out.println("Executing Win11");
	}

	@Test
	@EnabledIfEnvironmentVariable(named = "ENV", matches = ".*pro.*")
	public void executeOnlyInEnvironment() {
		System.out.println("Executing executeOnlyInEnvironment : ");
	}
}
