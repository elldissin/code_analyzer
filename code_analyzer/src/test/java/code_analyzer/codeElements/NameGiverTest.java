package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code_analyzer.Configuration;
import code_analyzer.Expression;

public class NameGiverTest {

	@Test
	public void giveNameTest() {
		NameGiver nameGiverTest = new NameGiver();
		Configuration configTest = new Configuration();
		Expression expressionTest = new Expression("table(Name,0,\"\")", configTest);
		String givenName;
		CodeElement elementTest = new Table(expressionTest);
		givenName = nameGiverTest.giveNameTo(elementTest);
		assertTrue("Expected name Name, got " + givenName, givenName.equals("Name"));
	}

}
