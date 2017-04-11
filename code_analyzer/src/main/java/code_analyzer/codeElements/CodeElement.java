package code_analyzer.codeElements;

import java.util.ArrayList;
import java.util.List;

import code_analyzer.Expression;

public abstract class CodeElement {
	protected String name;

	public String getName() {
		return name;
	}

	protected Expression expression;
	protected CodeElementType type;
	protected List<CodeElement> childList;

	public CodeElement(Expression expression) {
		childList = new ArrayList<CodeElement>();
		this.expression = expression;
	}

	public void setType(CodeElementType type) {
		this.type = type;
	}

	public CodeElementType getType() {
		return expression.getType();
	}

	public List<CodeElement> getChildList() {
		return childList;
	}

	public void addChild(CodeElement element) {
		childList.add(element);
	}

	public Expression getExpression() {
		return expression;
	}

}
