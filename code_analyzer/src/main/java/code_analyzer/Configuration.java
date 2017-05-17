package code_analyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import code_analyzer.codeElements.NameGiver;

public class Configuration {
	private String tableKeyWord;
	private String modifierKeyWord;
	private String fieldKeyWord;
	private String fieldPropertyKeyWord;
	private String argumentFinderRegex;
	private String functionNameFinderRegex;
	private BufferedReader configReader;
	private NameGiver nameGiver;
	private ArgumentFinder argumentFinder;
	private FunctionNameFinder functionNameFinder;

	public Configuration() {
		nameGiver = new NameGiver(this);
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
			argumentFinderRegex = configReader.readLine();
			functionNameFinderRegex = configReader.readLine();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		argumentFinder = new ArgumentFinder(argumentFinderRegex);
		functionNameFinder = new FunctionNameFinder(functionNameFinderRegex);
	}
	
	public String getProperty(String name) {
		if (name.toLowerCase().equals("tablekeyword")) {
			return getTableKeyword();
		}
		if (name.toLowerCase().equals("fieldkeyword")) {
			return getFieldKeyword();
		}
		if (name.toLowerCase().equals("modifierkeyword")) {
			return getModifierKeyword();
		}
		if (name.toLowerCase().equals("fieldpropertykeyword")) {
			return getFieldPropertyKeyword();
		}
		if (name.toLowerCase().equals("argumentfinderregex")) {
			return getArgumentFinderRegex();
		}
		if (name.toLowerCase().equals("functionnamefinderregex")) {
			return getFunctionNameFinderRegex();
		}
		if (name.toLowerCase().equals("functionnamefinderregex")) {
			return getFunctionNameFinderRegex();
		}
		return "No such property";
		
	}

	private String getArgumentFinderRegex() {
		return argumentFinderRegex;
	}

	private String getFunctionNameFinderRegex() {
		return functionNameFinderRegex;
	}

	private String getTableKeyword() {
		return tableKeyWord;
	}

	private String getFieldKeyword() {
		return fieldKeyWord;
	}

	private String getModifierKeyword() {
		return modifierKeyWord;
	}

	private String getFieldPropertyKeyword() {
		return fieldPropertyKeyWord;
	}

	public ArgumentFinder getArgumentFinder() {
		return argumentFinder;
	}

	public NameGiver getNameGiver() {
		return nameGiver;
	}

	public FunctionNameFinder getFunctionNameFinder() {
		return functionNameFinder;
	}

}
