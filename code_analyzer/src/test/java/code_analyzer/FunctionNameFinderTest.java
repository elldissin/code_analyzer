package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FunctionNameFinderTest {

	@Test
	public void testGetFunctionNameFor() {
		Configuration configTest = new Configuration();
		FunctionNameFinder functionNameFinder = new FunctionNameFinder(
				configTest.getProperty("functionNameFinderRegex"));
		String result = functionNameFinder.getFunctionNameFor("tableStart(some,args,here)");
		assertTrue("Wrong function name returned: " + result, result.equals("tableStart"));
		result = functionNameFinder.getFunctionNameFor("tableStart");
		assertTrue("Wrong function name returned: " + result, result.equals("tableStart"));
	}

}
