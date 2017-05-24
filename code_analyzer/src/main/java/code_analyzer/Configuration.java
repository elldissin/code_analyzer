package code_analyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {
	private static String tableKeyWord;
	private static String modifierKeyWord;
	private static String fieldKeyWord;
	private static String fieldPropertyKeyWord;
	private static String argumentFinderRegex;
	private static String functionNameFinderRegex;
	private static ArgumentFinder argumentFinder;
	private static FunctionNameFinder functionNameFinder;
	private static boolean isLoaded = false;

	private Configuration() {
		// intentionally empty and private
	}

	private static void init() {
		if (!isLoaded) {
			try {
				BufferedReader configReader;
				configReader = new BufferedReader(new FileReader("config.txt"));
				tableKeyWord = configReader.readLine();
				modifierKeyWord = configReader.readLine();
				fieldKeyWord = configReader.readLine();
				fieldPropertyKeyWord = configReader.readLine();
				argumentFinderRegex = configReader.readLine();
				functionNameFinderRegex = configReader.readLine();
				configReader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			argumentFinder = new ArgumentFinder(argumentFinderRegex);
			functionNameFinder = new FunctionNameFinder(functionNameFinderRegex);
			isLoaded = true;
		}
	}

	public static String getProperty(String name) {
		init();
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

	private static String getArgumentFinderRegex() {
		return argumentFinderRegex;
	}

	private static String getFunctionNameFinderRegex() {
		return functionNameFinderRegex;
	}

	private static String getTableKeyword() {
		return tableKeyWord;
	}

	private static String getFieldKeyword() {
		return fieldKeyWord;
	}

	private static String getModifierKeyword() {
		return modifierKeyWord;
	}

	private static String getFieldPropertyKeyword() {
		return fieldPropertyKeyWord;
	}

	public static ArgumentFinder getArgumentFinder() {
		init();
		return argumentFinder;
	}

	public static FunctionNameFinder getFunctionNameFinder() {
		init();
		return functionNameFinder;
	}

}
