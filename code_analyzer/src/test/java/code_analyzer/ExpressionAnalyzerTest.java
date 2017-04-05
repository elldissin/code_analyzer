package code_analyzer;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import code_analyzer.codeElements.CodeElement;

public class ExpressionAnalyzerTest {
	List<String> expressionList = new ArrayList<String>();

	@Test
	public void analyzeTest() {
		ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
		expressionList.add("tableStart(Name, 0, \" \");");
		expressionList.add("server use;");
		expressionList.add("fild 1;");
		expressionList.add("blabla bla for 1;");
		// expressionAnalyzer.analyze(expressionList.get(0));

		for (int i = 0; i < expressionList.size(); i++) {
			assertTrue("wrong expression type", i == expressionAnalyzer.analyze(expressionList.get(i)));
		}
	}

	@Test
	public void makeCodeElementTest() {
		CodeElement codeElement;
		ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
		codeElement = expressionAnalyzer.makeCodeElement(0);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Table"));
		codeElement = expressionAnalyzer.makeCodeElement(1);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("ServerLink"));
		codeElement = expressionAnalyzer.makeCodeElement(2);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Field"));
		codeElement = expressionAnalyzer.makeCodeElement(3);
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("FieldProperty"));

	}

}
