package code_analyzer;

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
		ArrayList<ExpressionArgument> result = new ArrayList<ExpressionArgument>();
		Matcher matcher = compiledPattern.matcher(expressionString);
		// group 0 is whole pattern, therefore start with 1
		while (matcher.find()) {
			for (int i = 1; i <= matcher.groupCount(); i++) {
				String name = deduceArgumentName(matcher.group(i));
				String type = deduceArgumentType(matcher.group(i));
				String value = deduceArgumentValue(matcher.group(i));
				ExpressionArgument argument = new ExpressionArgument(name, type, value);
				result.add(argument);
			}
		}
		return result;
	}

	private String deduceArgumentValue(String group) {
		return group;
	}

	private String deduceArgumentType(String group) {
		// TODO Auto-generated method stub
		return "StubType";
	}

	private String deduceArgumentName(String group) {
		// TODO Auto-generated method stub
		return "StubName";
	}

}
