package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code_analyzer.Configuration;
import code_analyzer.Expression;

public class DBElementTest {

	@Test
	public void testGetName() {
		Configuration configTest = new Configuration();
		Expression exprTest = new Expression(configTest.getProperty("tableKeyword") + "(MyTable,0,\"\")", configTest);
		DBElement dbElementTest = new Table(exprTest);
		String assignedName = dbElementTest.getName();
		assertTrue("Table name incorrect:" + assignedName, assignedName.equals("MyTable"));

		exprTest = new Expression(configTest.getProperty("fieldKeyword") + "(MyField,0,\"\")", configTest);
		dbElementTest = new Field(exprTest);
		assignedName = dbElementTest.getName();
		assertTrue("Field name incorrect:" + assignedName, assignedName.equals("MyField"));

		exprTest = new Expression(configTest.getProperty("modifierKeyword"), configTest);
		dbElementTest = new Modifier(exprTest);
		assignedName = dbElementTest.getName();
		assertTrue("Modifier name incorrect:" + assignedName, assignedName.equals(exprTest.getFunctionName()));

		exprTest = new Expression(configTest.getProperty("fieldPropertyKeyword"), configTest);
		dbElementTest = new FieldProperty(exprTest);
		assignedName = dbElementTest.getName();
		assertTrue("Field name incorrect:" + assignedName, assignedName.equals(exprTest.getFunctionName()));
	}

}
