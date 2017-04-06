package code_analyzer;

import static code_analyzer.codeElements.CodeElementType.FIELD;
import static code_analyzer.codeElements.CodeElementType.FIELD_PROPERTY;
import static code_analyzer.codeElements.CodeElementType.MODIFIER;
import static code_analyzer.codeElements.CodeElementType.TABLE;
import static code_analyzer.codeElements.CodeElementType.WRONGTYPE;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import code_analyzer.codeElements.CodeElement;
import code_analyzer.codeElements.CodeElementType;
import code_analyzer.codeElements.Field;
import code_analyzer.codeElements.FieldProperty;
import code_analyzer.codeElements.Modifier;
import code_analyzer.codeElements.Table;

public class ExpressionAnalyzer {
	private String tableKeyWord;
	private String modifierKeyWord;
	private String fieldKeyWord;
	private String fieldPropertyKeyWord;
	private BufferedReader configReader;

	public ExpressionAnalyzer() {
		try {
			configReader = new BufferedReader(new FileReader("config.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableKeyWord = configReader.readLine();
			modifierKeyWord = configReader.readLine();
			fieldKeyWord = configReader.readLine();
			fieldPropertyKeyWord = configReader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CodeElementType analyze(String string) {
		if (string.indexOf(tableKeyWord) != -1) {
			return TABLE;
		}
		if (string.indexOf(modifierKeyWord) != -1) {
			return MODIFIER;
		}
		if (string.indexOf(fieldKeyWord) != -1) {
			return FIELD;
		}
		if (string.indexOf(fieldPropertyKeyWord) != -1) {
			return FIELD_PROPERTY;
		}
		return WRONGTYPE;
	}

	public CodeElement makeCodeElement(CodeElementType type, String expression) {
		switch (type) {
		case TABLE:
			return new Table(expression);
		case MODIFIER:
			return new Modifier(expression);
		case FIELD:
			return new Field(expression);
		case FIELD_PROPERTY:
			return new FieldProperty(expression);
		}
		return null;
	}

}
