package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import code_analyzer.db_elements.DBElement;
import code_analyzer.db_elements.Field;
import code_analyzer.db_elements.FieldProperty;
import code_analyzer.db_elements.Modifier;
import code_analyzer.db_elements.Table;
import code_analyzer.source_analyze.Configuration;
import code_analyzer.source_analyze.Expression;

public class DBElementTest {

	@Test
	public void testGetName() {
		Expression exprTest = new Expression(Configuration.getProperty("tableKeyword") + "(MyTable,0,\"\")");
		DBElement dbElementTest = new Table(exprTest);
		String assignedName = dbElementTest.getName();
		assertTrue("Table name incorrect:" + assignedName, assignedName.equals("MyTable"));

		exprTest = new Expression(Configuration.getProperty("fieldKeyword") + "(MyField,0,\"\")");
		dbElementTest = new Field(exprTest);
		assignedName = dbElementTest.getName();
		assertTrue("Field name incorrect:" + assignedName, assignedName.equals("MyField"));

		exprTest = new Expression(Configuration.getProperty("modifierKeyword"));
		dbElementTest = new Modifier(exprTest);
		assignedName = dbElementTest.getName();
		assertTrue("Modifier name incorrect:" + assignedName, assignedName.equals(exprTest.getFunctionName()));

		exprTest = new Expression(Configuration.getProperty("fieldPropertyKeyword"));
		dbElementTest = new FieldProperty(exprTest);
		assignedName = dbElementTest.getName();
		assertTrue("Field name incorrect:" + assignedName, assignedName.equals(exprTest.getFunctionName()));
	}

}
