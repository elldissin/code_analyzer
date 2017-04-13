package code_analyzer;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code_analyzer.codeElements.CodeElement;

public class ExpressionAnalyzerTest {
	List<String> expressionList = new ArrayList<String>();

	@Test
	public void makeCodeElementTest() {
		CodeElement codeElement;
		Configuration configTest = new Configuration();
		ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
		Expression expressionTest = new Expression(configTest.getTableKeyword()+"(Name,0,0)", configTest);
		codeElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Table"));

		expressionTest = new Expression(configTest.getModifierKeyword(), configTest);
		codeElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Modifier"));

		expressionTest = new Expression(configTest.getFieldKeyword(), configTest);
		codeElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Field"));

		expressionTest = new Expression(configTest.getFieldPropertyKeyWord(), configTest);
		codeElement = expressionAnalyzer.makeCodeElement(expressionTest);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("FieldProperty"));

	}

}
