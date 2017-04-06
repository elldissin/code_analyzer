package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD;

public class Field extends CodeElement {
	public Field(String expression) {
		super(expression);
		type = FIELD;
	}
}
