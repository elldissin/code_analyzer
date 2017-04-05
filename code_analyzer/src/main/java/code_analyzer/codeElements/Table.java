package code_analyzer.codeElements;

import java.util.ArrayList;
import java.util.List;

public class Table extends CodeElement {
	List<Field> fieldList = new ArrayList<Field>();

	@Override
	public List<Field> getFieldList() {
		return fieldList;
	}

	@Override
	public void setFieldList(List<Field> fieldList) {
		this.fieldList = fieldList;
	}

}
