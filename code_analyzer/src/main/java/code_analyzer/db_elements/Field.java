package code_analyzer.db_elements;

import code_analyzer.source_analyze.Expression;

public class Field extends DBElement {
	public Field(Expression expression) {
		super(expression);
		// TODO set proper argument number when known
		name = expression.getArgumentList().get(0).getValue();
	}

	@Override
	public void putSelfToDB(DBStructure dbMaker) {
		dbMaker.getFieldList().add(this);
		if (!(dbMaker.getProcessingTableStack().isEmpty())) {
			dbMaker.getProcessingTableStack().peek().addChild(this);
			this.setParent(dbMaker.getProcessingTableStack().peek());
		}
		if (!(dbMaker.getProcessingFieldStack().isEmpty())) {
			dbMaker.getProcessingFieldStack().pop();
		}
		dbMaker.getProcessingFieldStack().push(this);
	}

}
