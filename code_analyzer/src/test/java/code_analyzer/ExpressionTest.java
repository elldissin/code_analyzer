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
		Expression expressionTest = new Expression(Configuration.getProperty("tableKeyword"));
		assertTrue("Expression type is not Table", expressionTest.getType() == TABLE);
		expressionTest = new Expression(Configuration.getProperty("modifierKeyword"));
		assertTrue("Expression type is not Modifier", expressionTest.getType() == MODIFIER);
		expressionTest = new Expression(Configuration.getProperty("fieldKeyword"));
		assertTrue("Expression type is not Field", expressionTest.getType() == FIELD);
		expressionTest = new Expression(Configuration.getProperty("fieldPropertyKeyword"));
		assertTrue("Expression type is not Property", expressionTest.getType() == FIELD_PROPERTY);
	}

	@Test
	public void testGetFunctionName() {
		Expression expressionTest = new Expression("tableStart(some,arguments,here)");
		String result = expressionTest.getFunctionName();
		assertTrue("Wrong function name in expression" + result, result.equals("tableStart"));
	}

}