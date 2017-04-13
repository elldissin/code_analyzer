package code_analyzer;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code_analyzer.codeElements.DBElement;

public class ExpressionAnalyzerTest {
	List<String> expressionList = new ArrayList<String>();

	@Test
	public void makeCodeElementTest() {
		DBElement dBElement;
		Configuration configTest = new Configuration();
		ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
		Expression expressionTest = new Expression(configTest.getTableKeyword()+"(Name,0,0)", configTest);
		dBElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("Table"));

		expressionTest = new Expression(configTest.getModifierKeyword(), configTest);
		dBElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("Modifier"));

		expressionTest = new Expression(configTest.getFieldKeyword(), configTest);
		dBElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("Field"));

		expressionTest = new Expression(configTest.getFieldPropertyKeyWord(), configTest);
		dBElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("FieldProperty"));

	}

}
