package code_analyzer.codeElements;

import code_analyzer.Expression;

public class Modifier extends DBElement {
	public Modifier(Expression expression) {
		super(expression);
		name = expression.getFunctionName();
	}

	@Override
	public void putSelfToDB(DBStructure dbMaker) {
		dbMaker.getModifierList().add(this);
		if (!(dbMaker.getProcessingTableStack().isEmpty())) {
			dbMaker.getProcessingTableStack().peek().addChild(this);
		}
	}
}
