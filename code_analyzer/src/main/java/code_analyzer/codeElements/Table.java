package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.TABLE;

public class Table extends CodeElement {
	public Table(String expression) {
		super(expression);
		type = TABLE;
	}

}
