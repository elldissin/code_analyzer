package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD;

import code_analyzer.Expression;

public class Field extends CodeElement {
	public Field(Expression expression) {
		super(expression);
		type = FIELD;
	}
}
