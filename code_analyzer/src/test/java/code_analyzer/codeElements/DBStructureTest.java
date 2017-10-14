package code_analyzer.codeElements;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import code_analyzer.db_elements.DBElement;
import code_analyzer.db_elements.DBStructure;
import code_analyzer.db_elements.Field;
import code_analyzer.db_elements.FieldProperty;
import code_analyzer.db_elements.Modifier;
import code_analyzer.db_elements.Table;
import code_analyzer.source_analyze.Configuration;
import code_analyzer.source_analyze.Expression;

public class DBStructureTest {
	private DBStructure dBStructure = new DBStructure();

	@Test
	public void putCodeElementTest() {

		List<DBElement> tableList = dBStructure.getTableList();
		Expression expressionTest = new Expression(Configuration.getProperty("tableKeyword") + "(TableName,0,0)");
		DBElement dBElement = new Table(expressionTest);
		dBStructure.addDBElement(dBElement);

		expressionTest = new Expression(Configuration.getProperty("modifierKeyword"));
		dBElement = new Modifier(expressionTest);
		dBStructure.addDBElement(dBElement);

		expressionTest = new Expression(Configuration.getProperty("fieldKeyword") + "(FieldName,0,0)");
		dBElement = new Field(expressionTest);
		dBStructure.addDBElement(dBElement);

		expressionTest = new Expression(Configuration.getProperty("fieldPropertyKeyword"));
		dBElement = new FieldProperty(expressionTest);
		dBStructure.addDBElement(dBElement);
		assertTrue("Wrong DB structure: tables", testTables());
		assertTrue("Wrong DB structure: modifiers", testModifiers());
		assertTrue("Wrong DB structure: fields", testFields());
		assertTrue("Wrong DB structure: field properties", testProperties());
		assertTrue("Wrong DB structure: property must have no children", testPropertiesChild());
	}

	private boolean testPropertiesChild() {
		DBElement tableTest, fieldTest, fieldPropertyTest;
		tableTest = dBStructure.getTableList().get(0);
		fieldTest = tableTest.getChildList().get(1);
		fieldPropertyTest = fieldTest.getChildList().get(0);
		if (fieldPropertyTest.getChildList().size() > 0) {
			return false;
		}
		return true;
	}

	private boolean testModifiers() {
		DBElement tableTest;
		tableTest = dBStructure.getTableList().get(0);
		if (!(tableTest.getChildList().get(0).getName().equals("modifier"))) {
			return false;
		}

		return true;
	}

	private boolean testProperties() {
		DBElement tableTest, fieldTest;
		tableTest = dBStructure.getTableList().get(0);
		fieldTest = tableTest.getChildList().get(1);
		if (!(fieldTest.getChildList().get(0).getName().equals("property"))) {
			System.out.println(fieldTest.getChildList().get(0).getName());
			return false;
		}
		return true;
	}

	private boolean testFields() {
		DBElement tableTest;
		tableTest = dBStructure.getTableList().get(0);
		if (!(tableTest.getChildList().get(1).getName().equals("FieldName"))) {
			return false;
		}
		return true;
	}

	private boolean testTables() {
		if (dBStructure.getTableList().size() != 1) {
			if (!(dBStructure.getTableList().get(0).getName().equals("TableName")))
				return false;
		}
		return true;
	}

}
