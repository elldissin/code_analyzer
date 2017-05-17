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
	private String functionName;

	public Expression(String expressionString, Configuration configuration) {
		this.expressionString = expressionString;
		this.configuration = configuration;
		this.functionName = deduceFunctionName();
		type = deduceType();
		fillArgumentList();
	}

	private String deduceFunctionName() {
		return configuration.getFunctionNameFinder().getFunctionNameFor(expressionString);
	}

	private CodeElementType deduceType() {
		if (functionName.equals(configuration.getProperty("tableKeyword"))) {
			return TABLE;
		}
		if (functionName.equals(configuration.getProperty("modifierKeyword"))) {
			return MODIFIER;
		}
		if (functionName.equals(configuration.getProperty("fieldKeyword"))) {
			return FIELD;
		}
		if (functionName.equals(configuration.getProperty("fieldPropertyKeyword"))) {
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

	public String getFunctionName() {
		return functionName;
	}

}
