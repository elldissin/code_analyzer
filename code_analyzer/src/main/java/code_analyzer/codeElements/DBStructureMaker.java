package code_analyzer.codeElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DBStructureMaker {
	List<DBElement> tableList = new ArrayList<DBElement>();
	List<DBElement> fieldList = new ArrayList<DBElement>();
	List<DBElement> modifierList = new ArrayList<DBElement>();
	List<DBElement> fieldPropertyList = new ArrayList<DBElement>();
	Stack<DBElement> processingTableStack = new Stack<DBElement>();
	Stack<DBElement> processingFieldStack = new Stack<DBElement>();

	public void putCodeElement(DBElement dBElement) {
		switch (dBElement.getType()) {
		case TABLE:
			tableList.add(dBElement);
			if (!processingTableStack.isEmpty()) {
				processingTableStack.pop();
			}
			processingTableStack.push(dBElement);
			break;
		case MODIFIER:
			modifierList.add(dBElement);
			if (!processingTableStack.isEmpty()) {
				processingTableStack.peek().addChild(dBElement);
			}
			break;
		case FIELD:
			fieldList.add(dBElement);
			if (!processingTableStack.isEmpty()) {
				processingTableStack.peek().addChild(dBElement);
			}
			if (!processingFieldStack.isEmpty()) {
				processingFieldStack.pop();
			}
			processingFieldStack.push(dBElement);
			break;
		case FIELD_PROPERTY:
			fieldPropertyList.add(dBElement);
			if (!processingFieldStack.isEmpty()) {
				processingFieldStack.peek().addChild(dBElement);
			}
			break;
		}

	}

	public List<DBElement> getTableList() {
		return tableList;
	}

}
