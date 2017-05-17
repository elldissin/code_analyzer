package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code_analyzer.Configuration;
import code_analyzer.Expression;

public class NameGiverTest {

	@Test
	public void giveNameTest() {
		Configuration configTest = new Configuration();
		NameGiver nameGiverTest = new NameGiver(configTest);
		Expression expressionTest = new Expression(configTest.getProperty("tableKeyword") + "(Name,0,0)", configTest);
		String givenName;
		DBElement elementTest = new Table(expressionTest);
		givenName = nameGiverTest.getNameFor(expressionTest);
		assertTrue("Expected name Name, got " + givenName, givenName.equals("Name"));
	}

}
