package code_analyzer.codeElements;

import java.util.ArrayList;
import java.util.List;

import code_analyzer.Expression;

public abstract class DBElement {
	protected String name;

	protected Expression expression;
	protected CodeElementType type;
	protected List<DBElement> childList;

	public DBElement(Expression expression) {
		childList = new ArrayList<DBElement>();
		this.expression = expression;
	}

	public abstract void putSelfToDB(DBStructure dbMaker);

	public void setType(CodeElementType type) {
		this.type = type;
	}

	public CodeElementType getType() {
		return expression.getType();
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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
