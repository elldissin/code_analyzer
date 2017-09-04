package code_analyzer.source_analyze;

import static code_analyzer.db_elements.DBElementType.FIELD;
import static code_analyzer.db_elements.DBElementType.FIELD_PROPERTY;
import static code_analyzer.db_elements.DBElementType.MODIFIER;
import static code_analyzer.db_elements.DBElementType.TABLE;
import static code_analyzer.db_elements.DBElementType.WRONGTYPE;

import java.util.List;

import code_analyzer.db_elements.DBElementType;

public class Expression {

	private String expressionString;
	private List<ExpressionArgument> argumentList;

	private DBElementType type;
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

	private DBElementType deduceType() {
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

	public DBElementType getType() {
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
