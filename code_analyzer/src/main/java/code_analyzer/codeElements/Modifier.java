package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.MODIFIER;

import code_analyzer.Expression;

public class Modifier extends CodeElement {
	public Modifier(Expression expression) {
		super(expression);
		type = MODIFIER;
	}
}
