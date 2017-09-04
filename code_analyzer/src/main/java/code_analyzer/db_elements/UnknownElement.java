package code_analyzer.db_elements;

import code_analyzer.source_analyze.Expression;

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
