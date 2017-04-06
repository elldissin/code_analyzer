package code_analyzer.codeElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DBStructureMaker {
	List<CodeElement> tableList = new ArrayList<CodeElement>();
	List<CodeElement> fieldList = new ArrayList<CodeElement>();
	List<CodeElement> modifierList = new ArrayList<CodeElement>();
	List<CodeElement> fieldPropertyList = new ArrayList<CodeElement>();
	Stack<CodeElement> processingTableStack = new Stack<CodeElement>();
	Stack<CodeElement> processingFieldStack = new Stack<CodeElement>();
	Stack<CodeElement> processingModifierStack = new Stack<CodeElement>();
	Stack<CodeElement> processingFieldPropertyStack = new Stack<CodeElement>();

	public void putCodeElement(CodeElement codeElement) {
		System.out.println(codeElement.getType());
		switch (codeElement.getType()) {
		case TABLE:
			tableList.add(codeElement);
		case MODIFIER:
			modifierList.add(codeElement);
		case FIELD:
			fieldList.add(codeElement);
		case FIELD_PROPERTY:
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
		return modifierList;
	}

	public void setServerLinkList(List<CodeElement> serverLinkList) {
		this.modifierList = serverLinkList;
	}

	public List<CodeElement> getFieldPropertyList() {
		return fieldPropertyList;
	}

	public void setFieldPropertyList(List<CodeElement> fieldPropertyList) {
		this.fieldPropertyList = fieldPropertyList;
	}

}
