package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;

import code_analyzer.Expression;

public class FieldProperty extends DBElement {
	public FieldProperty(Expression expression) {
		super(expression);
		type = FIELD_PROPERTY;
	}

	@Override
	public void putSelfToDB(DBStructure dbMaker) {
		dbMaker.getFieldPropertyList().add(this);
		if (!(dbMaker.processingFieldStack.isEmpty())) {
			dbMaker.processingFieldStack.peek().addChild(this);
		}
	}
}
