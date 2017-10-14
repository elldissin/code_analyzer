package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void testGetFunctionName() {
		Expression expressionTest = new Expression("tableStart(some,arguments,here)");
		String result = expressionTest.getFunctionName();
		assertTrue("Wrong function name in expression" + result, result.equals("tableStart"));
	}

}