package code_analyzer;

import static code_analyzer.codeElements.CodeElementType.FIELD;
import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;
import static code_analyzer.codeElements.CodeElementType.MODIFIER;
import static code_analyzer.codeElements.CodeElementType.TABLE;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void getTypeTest() {
		Configuration configTest = new Configuration();
		Expression expressionTest = new Expression(configTest.getProperty("tableKeyword"), configTest);
		assertTrue("Expression type is not Table", expressionTest.getType() == TABLE);
		expressionTest = new Expression(configTest.getProperty("modifierKeyword"), configTest);
		assertTrue("Expression type is not Modifier", expressionTest.getType() == MODIFIER);
		expressionTest = new Expression(configTest.getProperty("fieldKeyword"), configTest);
		assertTrue("Expression type is not Field", expressionTest.getType() == FIELD);
		expressionTest = new Expression(configTest.getProperty("fieldPropertyKeyword"), configTest);
		assertTrue("Expression type is not Property", expressionTest.getType() == FIELD_PROPERTY);
	}

	@Test
	public void testGetFunctionName() {
		Configuration configTest = new Configuration();
		Expression expressionTest = new Expression("tableStart(some,arguments,here)", configTest);
		String result = expressionTest.getFunctionName();
		assertTrue("Wrong function name in expression" + result, result.equals("tableStart"));
	}

}