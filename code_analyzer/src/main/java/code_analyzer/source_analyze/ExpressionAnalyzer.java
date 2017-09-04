package code_analyzer.source_analyze;

import code_analyzer.db_elements.DBElement;
import code_analyzer.db_elements.Field;
import code_analyzer.db_elements.FieldProperty;
import code_analyzer.db_elements.Modifier;
import code_analyzer.db_elements.Table;
import code_analyzer.db_elements.UnknownElement;

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
