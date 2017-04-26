package code_analyzer.codeElements;

import code_analyzer.Expression;

public class Table extends DBElement {
	public Table(Expression expression) {
		super(expression);
		name = expression.getArgumentList().get(0).getValue();
	}

	@Override
	public void putSelfToDB(DBStructure dbMaker) {
		dbMaker.getTableList().add(this);
		if (!(dbMaker.getProcessingTableStack().isEmpty())) {
			dbMaker.getProcessingTableStack().pop();
		}
		dbMaker.getProcessingTableStack().push(this);
	}

}
