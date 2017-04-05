package code_analyzer.codeElements;

import java.util.ArrayList;
import java.util.List;

public class DBStructureMaker {
	List<CodeElement> tableList = new ArrayList<CodeElement>();
	List<CodeElement> fieldList = new ArrayList<CodeElement>();
	List<CodeElement> serverLinkList = new ArrayList<CodeElement>();
	List<CodeElement> fieldPropertyList = new ArrayList<CodeElement>();

	public void putCodeElement(CodeElement codeElement) {
		switch (codeElement.getType()) {
		case 0:
			tableList.add(codeElement);
		case 1:
			serverLinkList.add(codeElement);
		case 2:
			fieldList.add(codeElement);
		case 3:
			fieldPropertyList.add(codeElement);
		}

	}

	public List<CodeElement> getTableList() {
		return tableList;
	}

	public void setTableList(List<CodeElement> tableList) {
		this.tableList = tableList;
	}

	public List<CodeElement> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<CodeElement> fieldList) {
		this.fieldList = fieldList;
	}

	public List<CodeElement> getServerLinkList() {
		return serverLinkList;
	}

	public void setServerLinkList(List<CodeElement> serverLinkList) {
		this.serverLinkList = serverLinkList;
	}

	public List<CodeElement> getFieldPropertyList() {
		return fieldPropertyList;
	}

	public void setFieldPropertyList(List<CodeElement> fieldPropertyList) {
		this.fieldPropertyList = fieldPropertyList;
	}

}
