package code_analyzer.db_elements;

import java.util.ArrayList;
import java.util.List;

import code_analyzer.source_analyze.Expression;

public abstract class DBElement {
	protected String name;
	protected String fileName;
	protected Expression expression;
	protected List<DBElement> childList;
	protected DBElement parent;

	public DBElement(Expression expression) {
		childList = new ArrayList<DBElement>();
		this.expression = expression;
	}

	public abstract void putSelfToDB(DBStructure dbMaker);

	public List<DBElement> getChildList() {
		return childList;
	}

	public DBElement getParent() {
		return parent;
	}

	public void setParent(DBElement parent) {
		this.parent = parent;
		return;
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

	public String getfileName() {
		return fileName;
	}

	public void setfileName(String fileName) {
		this.fileName = fileName;
		return;
	}
}
