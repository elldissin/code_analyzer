package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code_analyzer.source_analyze.Configuration;

public class ConfigurationTest {

	@Test
	public void testGetProperty() {
		assertTrue("Table keyword was not loaded by Configuration",
				!(Configuration.getProperty("tableKeyword").equals("No such property")));

		assertTrue("Field keyword was not loaded by Configuration",
				!(Configuration.getProperty("fieldKeyword").equals("No such property")));

		assertTrue("Modifier keyword was not loaded by Configuration",
				!(Configuration.getProperty("modifierKeyword").equals("No such property")));

		assertTrue("Field property keyword was not loaded by Configuration",
				!(Configuration.getProperty("fieldPropertyKeyword").equals("No such property")));

		assertTrue("ArgumentFinder regex was not loaded by Configuration",
				!(Configuration.getProperty("argumentFinderRegex").equals("No such property")));

		assertTrue("ArgumentFinder regex was not loaded by Configuration",
				!(Configuration.getProperty("functionNameFinderRegex").equals("No such property")));

		// Cases that must fail
		assertTrue("This request must fail, but was successful",
				(Configuration.getProperty("wrongProperty").equals("No such property")));
	}
}
