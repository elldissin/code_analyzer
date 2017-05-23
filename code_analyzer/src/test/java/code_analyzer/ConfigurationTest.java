package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigurationTest {
	private Configuration configurationTest = new Configuration();

	@Test
	public void testGetProperty() {
		assertTrue("Table keyword was not loaded by Configuration",
				!(configurationTest.getProperty("tableKeyword").equals("No such property")));

		assertTrue("Field keyword was not loaded by Configuration",
				!(configurationTest.getProperty("fieldKeyword").equals("No such property")));

		assertTrue("Modifier keyword was not loaded by Configuration",
				!(configurationTest.getProperty("modifierKeyword").equals("No such property")));

		assertTrue("Field property keyword was not loaded by Configuration",
				!(configurationTest.getProperty("fieldPropertyKeyword").equals("No such property")));

		assertTrue("ArgumentFinder regex was not loaded by Configuration",
				!(configurationTest.getProperty("argumentFinderRegex").equals("No such property")));

		assertTrue("ArgumentFinder regex was not loaded by Configuration",
				!(configurationTest.getProperty("functionNameFinderRegex").equals("No such property")));

		// Cases that must fail
		assertTrue("This request must fail, but was successful",
				(configurationTest.getProperty("wrongProperty").equals("No such property")));
	}
}
