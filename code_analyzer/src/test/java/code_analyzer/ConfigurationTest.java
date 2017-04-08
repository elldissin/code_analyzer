package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void isLoadedTest() {
		Configuration configTest = new Configuration();
		assertTrue("Configuration was not loaded", configTest.isLoaded());
	}

}
