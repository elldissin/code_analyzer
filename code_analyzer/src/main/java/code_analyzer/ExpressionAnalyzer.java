package code_analyzer;

import code_analyzer.codeElements.DBElement;
import code_analyzer.codeElements.Field;
import code_analyzer.codeElements.FieldProperty;
import code_analyzer.codeElements.Modifier;
import code_analyzer.codeElements.Table;
import code_analyzer.codeElements.UnknownElement;

public class ExpressionAnalyzer {

	public ExpressionAnalyzer() {
	}

	public DBElement makeDBElement(Expression expression) {
		switch (expression.getType()) {
		case TABLE:
			Table table = new Table(expression);
			return table;
		case MODIFIER:
			Modifier modifier = new Modifier(expression);
			return modifier;
		case FIELD:
			Field field = new Field(expression);
			return field;
		case FIELD_PROPERTY:
			FieldProperty fieldProperty = new FieldProperty(expression);
			return fieldProperty;
		}
		return new UnknownElement(expression);
	}

}
