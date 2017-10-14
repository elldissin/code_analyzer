package code_analyzer.source_analyze;

import java.util.List;

import code_analyzer.db_elements.DBElement;
import code_analyzer.db_elements.Field;
import code_analyzer.db_elements.FieldProperty;
import code_analyzer.db_elements.Modifier;
import code_analyzer.db_elements.Table;
import code_analyzer.db_elements.UnknownElement;

public class Expression {

	private String expressionString;
	private List<ExpressionArgument> argumentList;
	private String functionName;
	private String locationInfo;

	public Expression(String expressionString) {
		this.expressionString = expressionString;
		this.functionName = deduceFunctionName();
		fillArgumentList();
	}

	private String deduceFunctionName() {
		return Configuration.getFunctionNameFinder().getFunctionNameFor(expressionString);
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

	public DBElement toDBElement() {
		if (functionName.equals(Configuration.getProperty("tableKeyword"))) {
			return new Table(this);
		}
		if (functionName.equals(Configuration.getProperty("modifierKeyword"))) {
			return new Modifier(this);
		}
		if (functionName.equals(Configuration.getProperty("fieldKeyword"))) {
			return new Field(this);
		}
		if (functionName.equals(Configuration.getProperty("fieldPropertyKeyword"))) {
			return new FieldProperty(this);
		}
		return new UnknownElement(this);
	}

	public String getLocationInfo() {
		return locationInfo;
	}

	public void setLocationInfo(String locationInfo) {
		this.locationInfo = locationInfo;
	}

}
