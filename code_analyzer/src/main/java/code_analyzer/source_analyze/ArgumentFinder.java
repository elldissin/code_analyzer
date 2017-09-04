package code_analyzer.source_analyze;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentFinder {

	private String usedRegex;
	private Pattern compiledPattern;

	public ArgumentFinder(String usedRegex) {
		this.usedRegex = usedRegex;
		compiledPattern = Pattern.compile(usedRegex);
	}

	public List<ExpressionArgument> getArgumentListFor(String expressionString) {
		// expressionString = "MyTable(1,2,3)";
		String onlyArguments = "";
		ArrayList<ExpressionArgument> result = new ArrayList<ExpressionArgument>();
		Pattern onlyArgumentsPattern = Pattern.compile("\\((.*)\\)$");
		Matcher onlyArgumentsMatcher = onlyArgumentsPattern.matcher(expressionString);
		if (onlyArgumentsMatcher.find()) {
			onlyArguments = onlyArgumentsMatcher.group(1);
			Matcher singleArgumentMatcher = compiledPattern.matcher(onlyArguments);
			int i = 0;
			while (singleArgumentMatcher.find()) {
				i++;
				String name = "argument" + i;
				String type = deduceArgumentType(singleArgumentMatcher.group());
				String value = deduceArgumentValue(singleArgumentMatcher.group());
				ExpressionArgument argument = new ExpressionArgument(name, type, value);
				result.add(argument);
			}
		}
		return result;
	}

	private String deduceArgumentValue(String group) {
		return group.trim();
	}

	private String deduceArgumentType(String group) {
		// TODO Auto-generated method stub
		return "StubType";
	}

}
