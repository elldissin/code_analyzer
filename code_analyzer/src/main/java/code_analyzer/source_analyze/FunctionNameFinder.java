package code_analyzer.source_analyze;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionNameFinder {
	private String usedRegex;
	private Pattern compiledPattern;

	public FunctionNameFinder(String usedRegex) {
		this.usedRegex = usedRegex;
		compiledPattern = Pattern.compile(usedRegex);
	}

	public String getFunctionNameFor(String expressionString) {
		String result = "";
		Matcher matcher = compiledPattern.matcher(expressionString);

		if (matcher.find()) {
			if (matcher.groupCount() > 0) {
				result = matcher.group(1);
			} else {
				// result = matcher.group(0);
			}
		}
		return result;
	}
}
