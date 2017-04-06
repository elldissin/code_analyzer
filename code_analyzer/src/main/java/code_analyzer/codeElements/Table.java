package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.TABLE;

import java.util.ArrayList;
import java.util.List;

public class Table extends CodeElement {
	List<Field> fieldList = new ArrayList<Field>();

	public Table() {
		type = TABLE;
	}

	@Override
	public List<Field> getFieldList() {
		return fieldList;
	}

	@Override
	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}

}
