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
	private static XMLConfigLoader xmlConfig;

	private Configuration() {
		// intentionally empty and private
	}

	private static void init() {
		if (!isLoaded) {
			try {
				BufferedReader configReader;
				xmlConfig = new XMLConfigLoader();
				configReader = new BufferedReader(new FileReader("config.txt"));
				tableKeyWord = xmlConfig.getProperty("tablekeyword");
				modifierKeyWord = xmlConfig.getProperty("fieldkeyword");
				fieldKeyWord = xmlConfig.getProperty("modifierkeyword");
				fieldPropertyKeyWord = xmlConfig.getProperty("fieldpropertykeyword");
				argumentFinderRegex = xmlConfig.getProperty("argumentfinderregex");
				functionNameFinderRegex = xmlConfig.getProperty("functionnamefinderregex");
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
		if (name.equals("tablekeyword")) {
			return tableKeyWord;
		}
		if (name.equals("fieldkeyword")) {
			return fieldKeyWord;
		}
		if (name.equals("modifierkeyword")) {
			return modifierKeyWord;
		}
		if (name.equals("fieldpropertykeyword")) {
			return fieldPropertyKeyWord;
		}
		if (name.equals("argumentfinderregex")) {
			return argumentFinderRegex;
		}
		if (name.equals("functionnamefinderregex")) {
			return functionNameFinderRegex;
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
