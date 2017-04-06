package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD;
import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;
import static code_analyzer.codeElements.CodeElementType.MODIFIER;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class DBStructureMakerTest {
	private DBStructureMaker dBStructureMaker = new DBStructureMaker();

	@Test
	public void putCodeElementTest() {

		List<CodeElement> tableList = dBStructureMaker.getTableList();
		CodeElement codeElement = new Table();
		dBStructureMaker.putCodeElement(codeElement);
		codeElement = new Modifier();
		dBStructureMaker.putCodeElement(codeElement);
		codeElement = new Field();
		dBStructureMaker.putCodeElement(codeElement);
		codeElement = new FieldProperty();
		dBStructureMaker.putCodeElement(codeElement);
		assertTrue("Wrong DB structure: tables", testTables());
		assertTrue("Wrong DB structure: modifiers", testModifiers());
		assertTrue("Wrong DB structure: fields", testFields());
		assertTrue("Wrong DB structure: field properties", testProperties());
		assertTrue("Wrong DB structure: property must have no children", testPropertiesChild());
	}

	private boolean testPropertiesChild() {
		CodeElement tableTest, fieldTest, fieldPropertyTest;
		tableTest = dBStructureMaker.getTableList().get(0);
		fieldTest = tableTest.getChildList().get(1);
		fieldPropertyTest = fieldTest.getChildList().get(0);
		if (fieldPropertyTest.getChildList().size() > 0) {
			return false;
		}
		return true;
	}

	private boolean testModifiers() {
		CodeElement tableTest;
		tableTest = dBStructureMaker.getTableList().get(0);
		if (tableTest.getChildList().get(0).getType() != MODIFIER) {
			return false;
		}

		return true;
	}

	private boolean testProperties() {
		CodeElement tableTest, fieldTest;
		tableTest = dBStructureMaker.getTableList().get(0);
		fieldTest = tableTest.getChildList().get(1);
		if (fieldTest.getChildList().get(0).getType() != FIELD_PROPERTY) {
			return false;
		}
		return true;
	}

	private boolean testFields() {
		CodeElement tableTest;
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

	// @Test
	// public void putElementToParentTest() {
	// dBStructureMaker.putElementToParent(codeElement1);
	// List<CodeElement> tableList = dBStructureMaker.getTableList();
	// tableList.get(tableList.size()).getFieldList();
	//
	// }

}
