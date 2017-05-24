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
	private String functionName;

	public Expression(String expressionString) {
		this.expressionString = expressionString;
		this.functionName = deduceFunctionName();
		type = deduceType();
		fillArgumentList();
	}

	private String deduceFunctionName() {
		return Configuration.getFunctionNameFinder().getFunctionNameFor(expressionString);
	}

	private CodeElementType deduceType() {
		if (functionName.equals(Configuration.getProperty("tableKeyword"))) {
			return TABLE;
		}
		if (functionName.equals(Configuration.getProperty("modifierKeyword"))) {
			return MODIFIER;
		}
		if (functionName.equals(Configuration.getProperty("fieldKeyword"))) {
			return FIELD;
		}
		if (functionName.equals(Configuration.getProperty("fieldPropertyKeyword"))) {
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
		argumentList = Configuration.getArgumentFinder().getArgumentListFor(expressionString);
	}

	public List<ExpressionArgument> getArgumentList() {
		return argumentList;
	}

	public String getFunctionName() {
		return functionName;
	}

}
