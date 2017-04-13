package code_analyzer;

import code_analyzer.codeElements.DBElement;
import code_analyzer.codeElements.Field;
import code_analyzer.codeElements.FieldProperty;
import code_analyzer.codeElements.Modifier;
import code_analyzer.codeElements.Table;

public class ExpressionAnalyzer {

	public ExpressionAnalyzer() {
	}

	public DBElement makeCodeElement(Expression expression) {
		switch (expression.getType()) {
		case TABLE:
			return new Table(expression);
		case MODIFIER:
			return new Modifier(expression);
		case FIELD:
			return new Field(expression);
		case FIELD_PROPERTY:
			return new FieldProperty(expression);
		}
		return null;
	}

}
