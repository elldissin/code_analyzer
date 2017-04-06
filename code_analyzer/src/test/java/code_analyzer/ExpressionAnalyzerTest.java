package code_analyzer;

import static code_analyzer.codeElements.CodeElementType.FIELD;
import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;
import static code_analyzer.codeElements.CodeElementType.MODIFIER;
import static code_analyzer.codeElements.CodeElementType.TABLE;
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
		expressionList.add("table(name,1,\" \")");
		expressionList.add("serverLink,0,1");
		expressionList.add("field(nameF)");
		expressionList.add("Property(nameF)");
		// expressionAnalyzer.analyze(expressionList.get(0));

		for (int i = 0; i < expressionList.size(); i++) {
			assertTrue("wrong expression type", i == expressionAnalyzer.analyze(expressionList.get(i)).getValue());
		}
	}

	@Test
	public void makeCodeElementTest() {
		CodeElement codeElement;
		ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
		codeElement = expressionAnalyzer.makeCodeElement(TABLE, "expression");
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Table"));
		codeElement = expressionAnalyzer.makeCodeElement(MODIFIER, "expression");
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Modifier"));
		codeElement = expressionAnalyzer.makeCodeElement(FIELD, "expression");
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("Field"));
		codeElement = expressionAnalyzer.makeCodeElement(FIELD_PROPERTY, "expression");
		assertTrue("wrong class " + codeElement.getClass().getSimpleName(),
				codeElement.getClass().getSimpleName().equals("FieldProperty"));

	}

}
