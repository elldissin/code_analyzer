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
		Expression expressionTest = new Expression("table", configTest);
		assertTrue("Expression type is not Table", expressionTest.getType() == TABLE);
		expressionTest = new Expression("serverLink", configTest);
		assertTrue("Expression type is not Modifier", expressionTest.getType() == MODIFIER);
		expressionTest = new Expression("field", configTest);
		assertTrue("Expression type is not Field", expressionTest.getType() == FIELD);
		expressionTest = new Expression("Property", configTest);
		assertTrue("Expression type is not Property", expressionTest.getType() == FIELD_PROPERTY);
	}

}