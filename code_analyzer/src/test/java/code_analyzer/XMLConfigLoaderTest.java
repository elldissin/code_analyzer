package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class XMLConfigLoaderTest {

	@Test
	public void testGetDoc() {
		XMLConfigLoader xMLConfigLoader = new XMLConfigLoader();
		String result = "";
		result = xMLConfigLoader.getProperty("tablekeyword");
		assertTrue("Wrong property value read from XML:" + result, result.equals("tableStart"));
		result = xMLConfigLoader.getProperty("fieldkeyword");
		assertTrue("Wrong property value read from XML:" + result, result.equals("field"));
		result = xMLConfigLoader.getProperty("modifierkeyword");
		assertTrue("Wrong property value read from XML:" + result, result.equals("modifier"));
		result = xMLConfigLoader.getProperty("fieldpropertykeyword");
		assertTrue("Wrong property value read from XML:" + result, result.equals("property"));
		// NOTE DOUBLE \\ for Java
		result = xMLConfigLoader.getProperty("argumentfinderregex");
		assertTrue("Wrong property value read from XML:" + result, result.equals("([^,]+\\(.+?\\))|([^,]+)"));
		result = xMLConfigLoader.getProperty("functionnamefinderregex");
		assertTrue("Wrong property value read from XML:" + result, result.equals("([^\\(\\)]+)(\\(.+\\))*"));

		result = xMLConfigLoader.getProperty("somethingwrong");
		assertTrue("Wrong property value read from XML:" + result, result.equals("No such property"));
	}

}
