package code_analyzer.db_elements;

import java.util.ArrayList;
import java.util.List;

import code_analyzer.source_analyze.Expression;

public abstract class DBElement {
	protected String name;

	protected Expression expression;
	protected DBElementType type;
	protected List<DBElement> childList;

	public DBElement(Expression expression) {
		childList = new ArrayList<DBElement>();
		this.expression = expression;
		type = expression.getType();
	}

	public abstract void putSelfToDB(DBStructure dbMaker);

	public void setType(DBElementType type) {
		this.type = type;
	}

	public DBElementType getType() {
		return type;
	}

	public List<DBElement> getChildList() {
		return childList;
	}

	public void addChild(DBElement element) {
		childList.add(element);
	}

	public Expression getExpression() {
		return expression;
	}

	public String getName() {
		return name;
	}
}
