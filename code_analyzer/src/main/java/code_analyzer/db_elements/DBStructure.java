package code_analyzer.db_elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DBStructure {
	List<DBElement> tableList = new ArrayList<DBElement>();
	List<DBElement> fieldList = new ArrayList<DBElement>();
	List<DBElement> modifierList = new ArrayList<DBElement>();
	List<DBElement> fieldPropertyList = new ArrayList<DBElement>();
	Stack<DBElement> processingTableStack = new Stack<DBElement>();
	Stack<DBElement> processingFieldStack = new Stack<DBElement>();

	public void putCodeElement(DBElement dBElement) {
		dBElement.putSelfToDB(this);
	}

	public List<DBElement> getFieldList() {
		return fieldList;
	}

	public List<DBElement> getModifierList() {
		return modifierList;
	}

	public List<DBElement> getFieldPropertyList() {
		return fieldPropertyList;
	}

	public List<DBElement> getTableList() {
		return tableList;
	}

	public Stack<DBElement> getProcessingTableStack() {
		return processingTableStack;
	}

	public Stack<DBElement> getProcessingFieldStack() {
		return processingFieldStack;
	}

	public void clear() {
		tableList.clear();
		fieldList.clear();
		modifierList.clear();
		fieldPropertyList.clear();
		processingTableStack.clear();
		processingFieldStack.clear();
		return;
	}

	public int getIndexByName(String name) {
		int index = -1;
		for (int i = 0; i < tableList.size(); i++) {
			if (name == tableList.get(i).getName()) {
				index = i;
			}
		}
		return index;
	}
}
