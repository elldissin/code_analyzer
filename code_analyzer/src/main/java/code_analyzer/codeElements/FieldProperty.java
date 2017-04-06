package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;

public class FieldProperty extends CodeElement {
	public FieldProperty(String expression) {
		super(expression);
		type = FIELD_PROPERTY;
	}
}
