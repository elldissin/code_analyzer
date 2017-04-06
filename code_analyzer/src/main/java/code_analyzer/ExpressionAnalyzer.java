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

		// String fullFile = "tableStart(Name, 0, \" \")";
		// String result1[], result2[];
		// int i = 0;
		// result1 = string.split("tableStart");
		// result2 = result1[1].split(",");
		// for (i = 0; i < result2.length; i++) {
		// result2[i] = result2[i].trim();
		// }
		// StringBuffer stringBuffer = new StringBuffer(result2[0]);
		// stringBuffer.deleteCharAt(0);
		// result2[0] = stringBuffer.toString();
		//
		// int lastSymbol = result2[2].length() - 1;
		// stringBuffer = new StringBuffer(result2[2]);
		// stringBuffer.deleteCharAt(lastSymbol);
		// result2[2] = stringBuffer.toString();
		//
		// for (i = 0; i < result2.length; i++) {
		// System.out.println(result2[i]);
		// }

	}

	public CodeElement makeCodeElement(CodeElementType type) {
		switch (type) {
		case TABLE:
			return new Table();
		case MODIFIER:
			return new Modifier();
		case FIELD:
			return new Field();
		case FIELD_PROPERTY:
			return new FieldProperty();
		}
		return null;
	}

}
