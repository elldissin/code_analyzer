package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.FIELD;

import code_analyzer.Expression;

public class Field extends DBElement {
	public Field(Expression expression) {
		super(expression);
		type = FIELD;
	}

	@Override
	public void putSelfToDB(DBStructure dbMaker) {
		dbMaker.getFieldList().add(this);
		if (!(dbMaker.getProcessingTableStack().isEmpty())) {
			dbMaker.getProcessingTableStack().peek().addChild(this);
		}
		if (!(dbMaker.getProcessingFieldStack().isEmpty())) {
			dbMaker.getProcessingFieldStack().pop();
		}
		dbMaker.getProcessingFieldStack().push(this);
	}

}
