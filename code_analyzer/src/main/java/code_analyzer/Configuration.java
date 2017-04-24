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

	public String getArgumentFinderRegex() {
		return argumentFinderRegex;
	}

	public String getFunctionNameFinderRegex() {
		return functionNameFinderRegex;
	}

	public String getTableKeyword() {
		return tableKeyWord;
	}

	public String getFieldKeyword() {
		return fieldKeyWord;
	}

	public String getModifierKeyword() {
		return modifierKeyWord;
	}

	public String getFieldPropertyKeyWord() {
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
