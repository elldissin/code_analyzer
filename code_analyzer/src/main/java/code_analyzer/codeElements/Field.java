package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD;

import code_analyzer.Expression;

public class Field extends DBElement {
	public Field(Expression expression) {
		super(expression);
		type = FIELD;
	}
}
