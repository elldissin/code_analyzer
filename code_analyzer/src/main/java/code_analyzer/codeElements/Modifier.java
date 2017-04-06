package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.MODIFIER;

public class Modifier extends CodeElement {
	public Modifier(String expression) {
		super(expression);
		type = MODIFIER;
	}
}
