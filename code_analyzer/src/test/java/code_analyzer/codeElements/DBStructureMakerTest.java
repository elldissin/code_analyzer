package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD;
import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;
import static code_analyzer.codeElements.CodeElementType.MODIFIER;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import code_analyzer.Configuration;
import code_analyzer.Expression;

public class DBStructureMakerTest {
	private DBStructureMaker dBStructureMaker = new DBStructureMaker();

	@Test
	public void putCodeElementTest() {

		List<DBElement> tableList = dBStructureMaker.getTableList();
		Configuration configTest = new Configuration();
		Expression expressionTest = new Expression(configTest.getTableKeyword()+"(Name,0,0)", configTest);
		DBElement dBElement = new Table(expressionTest);
		dBStructureMaker.putCodeElement(dBElement);

		expressionTest = new Expression(configTest.getModifierKeyword(), configTest);
		dBElement = new Modifier(expressionTest);
		dBStructureMaker.putCodeElement(dBElement);

		expressionTest = new Expression(configTest.getFieldKeyword(), configTest);
		dBElement = new Field(expressionTest);
		dBStructureMaker.putCodeElement(dBElement);

		expressionTest = new Expression(configTest.getFieldPropertyKeyWord(), configTest);
		dBElement = new FieldProperty(expressionTest);
		dBStructureMaker.putCodeElement(dBElement);
		assertTrue("Wrong DB structure: tables", testTables());
		assertTrue("Wrong DB structure: modifiers", testModifiers());
		assertTrue("Wrong DB structure: fields", testFields());
		assertTrue("Wrong DB structure: field properties", testProperties());
		assertTrue("Wrong DB structure: property must have no children", testPropertiesChild());
	}

	private boolean testPropertiesChild() {
		DBElement tableTest, fieldTest, fieldPropertyTest;
		tableTest = dBStructureMaker.getTableList().get(0);
		fieldTest = tableTest.getChildList().get(1);
		fieldPropertyTest = fieldTest.getChildList().get(0);
		if (fieldPropertyTest.getChildList().size() > 0) {
			return false;
		}
		return true;
	}

	private boolean testModifiers() {
		DBElement tableTest;
		tableTest = dBStructureMaker.getTableList().get(0);
		if (tableTest.getChildList().get(0).getType() != MODIFIER) {
			return false;
		}

		return true;
	}

	private boolean testProperties() {
		DBElement tableTest, fieldTest;
		tableTest = dBStructureMaker.getTableList().get(0);
		fieldTest = tableTest.getChildList().get(1);
		if (fieldTest.getChildList().get(0).getType() != FIELD_PROPERTY) {
			return false;
		}
		return true;
	}

	private boolean testFields() {
		DBElement tableTest;
		tableTest = dBStructureMaker.getTableList().get(0);
		if (tableTest.getChildList().get(1).getType() != FIELD) {
			return false;
		}
		return true;
	}

	private boolean testTables() {
		if (dBStructureMaker.getTableList().size() != 1) {
			return false;
		}
		return true;
	}

}
