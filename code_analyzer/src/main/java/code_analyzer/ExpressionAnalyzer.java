package code_analyzer;

import static code_analyzer.codeElements.CodeElementType.FIELD;
import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;
import static code_analyzer.codeElements.CodeElementType.MODIFIER;
import static code_analyzer.codeElements.CodeElementType.TABLE;
import static code_analyzer.codeElements.CodeElementType.WRONGTYPE;

import code_analyzer.codeElements.CodeElement;
import code_analyzer.codeElements.CodeElementType;
import code_analyzer.codeElements.Field;
import code_analyzer.codeElements.FieldProperty;
import code_analyzer.codeElements.Modifier;
import code_analyzer.codeElements.Table;

public class ExpressionAnalyzer {
	private Configuration configuration;

	public ExpressionAnalyzer() {
		configuration = new Configuration();
	}

	public CodeElementType analyze(String string) {
		if (string.indexOf(configuration.getTableKeyword()) != -1) {
			return TABLE;
		}
		if (string.indexOf(configuration.getModifierKeyword()) != -1) {
			return MODIFIER;
		}
		if (string.indexOf(configuration.getFieldKeyword()) != -1) {
			return FIELD;
		}
		if (string.indexOf(configuration.getFieldPropertyKeyWord()) != -1) {
			return FIELD_PROPERTY;
		}
		return WRONGTYPE;
	}

	public CodeElement makeCodeElement(CodeElementType type, String expression) {
		switch (type) {
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
