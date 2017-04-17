package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigurationTest {
	private Configuration configurationTest = new Configuration();

	@Test
	public void testGetTableKeyword() {
		assertTrue("Table keyword was not loaded by Configuration", !(configurationTest.getTableKeyword().equals("")));
	}

	@Test
	public void testGetFieldKeyword() {
		assertTrue("Field keyword was not loaded by Configuration", !(configurationTest.getFieldKeyword().equals("")));
	}

	@Test
	public void testGetModifierKeyword() {
		assertTrue("Modifier keyword was not loaded by Configuration",
				!(configurationTest.getModifierKeyword().equals("")));
	}

	@Test
	public void testGetFieldPropertyKeyWord() {
		assertTrue("Field property keyword was not loaded by Configuration",
				!(configurationTest.getFieldPropertyKeyWord().equals("")));
	}

}
