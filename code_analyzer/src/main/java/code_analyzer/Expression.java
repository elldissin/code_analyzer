package code_analyzer;

import static code_analyzer.codeElements.CodeElementType.FIELD;
import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;
import static code_analyzer.codeElements.CodeElementType.MODIFIER;
import static code_analyzer.codeElements.CodeElementType.TABLE;
import static code_analyzer.codeElements.CodeElementType.WRONGTYPE;

import java.util.List;

import code_analyzer.codeElements.CodeElementType;

public class Expression {

	private String expressionString;
	private List<ExpressionArgument> argumentList;

	private CodeElementType type;
	private Configuration configuration;

	public Expression(String expressionString, Configuration configuration) {
		this.expressionString = expressionString;
		this.configuration = configuration;
		type = deduceType();
		fillArgumentList();
	}

	private CodeElementType deduceType() {
		if (expressionString.indexOf(configuration.getTableKeyword()) != -1) {
			return TABLE;
		}
		if (expressionString.indexOf(configuration.getModifierKeyword()) != -1) {
			return MODIFIER;
		}
		if (expressionString.indexOf(configuration.getFieldKeyword()) != -1) {
			return FIELD;
		}
		if (expressionString.indexOf(configuration.getFieldPropertyKeyWord()) != -1) {
			return FIELD_PROPERTY;
		}
		return WRONGTYPE;
	}

	public CodeElementType getType() {
		return type;
	}

	public String toString() {
		return expressionString;
	}

	private void fillArgumentList() {
		argumentList = configuration.getArgumentFinder().getArgumentListFor(expressionString);
	}

	public List<ExpressionArgument> getArgumentList() {
		return argumentList;
	}
}
