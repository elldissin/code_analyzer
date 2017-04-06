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

	public void putCodeElement(CodeElement codeElement) {
		switch (codeElement.getType()) {
		case TABLE:
			tableList.add(codeElement);
			if (!processingTableStack.isEmpty()) {
				processingTableStack.pop();
			}
			processingTableStack.push(codeElement);
			break;
		case MODIFIER:
			modifierList.add(codeElement);
			if (!processingTableStack.isEmpty()) {
				processingTableStack.peek().addChild(codeElement);
			}
			break;
		case FIELD:
			fieldList.add(codeElement);
			if (!processingTableStack.isEmpty()) {
				processingTableStack.peek().addChild(codeElement);
			}
			if (!processingFieldStack.isEmpty()) {
				processingFieldStack.pop();
			}
			processingFieldStack.push(codeElement);
			break;
		case FIELD_PROPERTY:
			fieldPropertyList.add(codeElement);
			if (!processingFieldStack.isEmpty()) {
				processingFieldStack.peek().addChild(codeElement);
			}
			break;
		}

	}

	public List<CodeElement> getTableList() {
		return tableList;
	}

}
