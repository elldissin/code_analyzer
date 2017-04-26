package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code_analyzer.Configuration;
import code_analyzer.Expression;

public class DBElementTest {

	@Test
	public void testGetName() {
		Configuration configTest = new Configuration();
		Expression exprTest = new Expression(configTest.getTableKeyword() + "(MyTable,0,\"\")", configTest);
		DBElement dbElementTest = new Table(exprTest);
		String assignedName = dbElementTest.getName();
		assertTrue("Table name incorrect:" + assignedName, assignedName.equals("MyTable"));
		// TODO add tests for each of DBELement children
	}

}
