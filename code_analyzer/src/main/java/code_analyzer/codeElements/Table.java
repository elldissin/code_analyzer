package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.TABLE;

import code_analyzer.Expression;

public class Table extends DBElement {
	public Table(Expression expression) {
		super(expression);
		type = TABLE;
	}

}
