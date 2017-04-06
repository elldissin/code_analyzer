package code_analyzer.codeElements;

import java.util.List;

public abstract class CodeElement {
	protected CodeElementType type;

	public void setType(CodeElementType type) {
		this.type = type;
	}

	public CodeElementType getType() {
		return type;
	}

	public List<Field> getFieldList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFieldList(List<Field> fieldList) {
		// TODO Auto-generated method stub

	}
}
