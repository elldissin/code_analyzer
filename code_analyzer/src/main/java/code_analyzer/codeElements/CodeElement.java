package code_analyzer.codeElements;

import java.util.List;

public abstract class CodeElement {
	private int type;

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
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
