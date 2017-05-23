package code_analyzer.codeElements;

import code_analyzer.Expression;

public class FieldProperty extends DBElement {
	public FieldProperty(Expression expression) {
		super(expression);
		name = expression.getFunctionName();
	}

	@Override
	public void putSelfToDB(DBStructure dbMaker) {
		dbMaker.getFieldPropertyList().add(this);
		if (!(dbMaker.processingFieldStack.isEmpty())) {
			dbMaker.processingFieldStack.peek().addChild(this);
		}
	}
}
