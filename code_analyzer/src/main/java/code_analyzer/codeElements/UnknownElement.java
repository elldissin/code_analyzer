package code_analyzer.codeElements;

import code_analyzer.Expression;

public class UnknownElement extends DBElement {

	public UnknownElement(Expression expression) {
		super(expression);
		name = "UnknownElement";
	}

	@Override
	public void putSelfToDB(DBStructure dbMaker) {
		// intentionally does nothing
	}

}
