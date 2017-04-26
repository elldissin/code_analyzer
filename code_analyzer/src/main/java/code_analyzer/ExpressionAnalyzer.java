package code_analyzer;

import code_analyzer.codeElements.DBElement;
import code_analyzer.codeElements.Field;
import code_analyzer.codeElements.FieldProperty;
import code_analyzer.codeElements.Modifier;
import code_analyzer.codeElements.Table;

public class ExpressionAnalyzer {
	Configuration configuration;

	public ExpressionAnalyzer(Configuration configuration) {
		this.configuration = configuration;
	}

	public DBElement makeCodeElement(Expression expression) {
		String name = configuration.getNameGiver().getNameFor(expression);
		switch (expression.getType()) {
		case TABLE:
			Table table = new Table(expression);
			// table.setName(name);//TODO remove if talbe knows its name
			return table;
		case MODIFIER:
			Modifier modifier = new Modifier(expression);
			modifier.setName(name);
			return modifier;
		case FIELD:
			Field field = new Field(expression);
			field.setName(name);
			return field;
		case FIELD_PROPERTY:
			FieldProperty fieldProperty = new FieldProperty(expression);
			fieldProperty.setName(name);
			return fieldProperty;
		}
		return null;
	}

}
