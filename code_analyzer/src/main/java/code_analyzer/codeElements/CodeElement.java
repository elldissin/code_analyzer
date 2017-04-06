package code_analyzer.codeElements;

import java.util.ArrayList;
import java.util.List;

public abstract class CodeElement {
	protected CodeElementType type;
	protected List<CodeElement> childList;

	public CodeElement() {
		childList = new ArrayList<CodeElement>();
	}

	public void setType(CodeElementType type) {
		this.type = type;
	}

	public CodeElementType getType() {
		return type;
	}

	public List<CodeElement> getChildList() {
		return childList;
	}

	public void addChild(CodeElement element) {
		childList.add(element);
	}

}
