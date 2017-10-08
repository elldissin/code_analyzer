package code_analyzer.source_analyze;

public class Configuration {
	private static String tableKeyWord;
	private static String modifierKeyWord;
	private static String fieldKeyWord;
	private static String fieldPropertyKeyWord;
	private static String argumentFinderRegex;
	private static String functionNameFinderRegex;
	private static String targetFileType;
	private static ArgumentFinder argumentFinder;
	private static FunctionNameFinder functionNameFinder;
	private static boolean isLoaded = false;
	private static XMLConfigLoader xmlConfig;

	private Configuration() {
		// intentionally empty and private
	}

	private static void init() {
		if (!isLoaded) {

			xmlConfig = new XMLConfigLoader();
			tableKeyWord = xmlConfig.getProperty("tablekeyword");
			modifierKeyWord = xmlConfig.getProperty("modifierkeyword");
			fieldKeyWord = xmlConfig.getProperty("fieldkeyword");
			fieldPropertyKeyWord = xmlConfig.getProperty("fieldpropertykeyword");
			argumentFinderRegex = xmlConfig.getProperty("argumentfinderregex");
			functionNameFinderRegex = xmlConfig.getProperty("functionnamefinderregex");
			targetFileType = xmlConfig.getProperty("targetfiletype");
			argumentFinder = new ArgumentFinder(argumentFinderRegex);
			functionNameFinder = new FunctionNameFinder(functionNameFinderRegex);
			isLoaded = true;
		}
	}

	public static String getProperty(String name) {
		init();
		if (name.toLowerCase().equals("tablekeyword")) {
			return tableKeyWord;
		}
		if (name.toLowerCase().equals("fieldkeyword")) {
			return fieldKeyWord;
		}
		if (name.toLowerCase().equals("modifierkeyword")) {
			return modifierKeyWord;
		}
		if (name.toLowerCase().equals("fieldpropertykeyword")) {
			return fieldPropertyKeyWord;
		}
		if (name.toLowerCase().equals("argumentfinderregex")) {
			return argumentFinderRegex;
		}
		if (name.toLowerCase().equals("functionnamefinderregex")) {
			return functionNameFinderRegex;
		}
		if (name.toLowerCase().equals("targetfiletype")) {
			return targetFileType;
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
