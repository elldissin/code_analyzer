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
		ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
		Expression expressionTest = new Expression(Configuration.getProperty("tableKeyword") + "(Name,0,0)");
		dBElement = expressionAnalyzer.makeDBElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("Table"));

		expressionTest = new Expression(Configuration.getProperty("modifierKeyword"));
		dBElement = expressionAnalyzer.makeDBElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("Modifier"));

		expressionTest = new Expression(Configuration.getProperty("fieldKeyword") + "(Name,0,0)");
		dBElement = expressionAnalyzer.makeDBElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("Field"));

		expressionTest = new Expression(Configuration.getProperty("fieldPropertyKeyword"));
		dBElement = expressionAnalyzer.makeDBElement(expressionTest);
		assertTrue("wrong class " + dBElement.getClass().getSimpleName(),
				dBElement.getClass().getSimpleName().equals("FieldProperty"));

	}

}
