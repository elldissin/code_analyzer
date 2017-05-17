package code_analyzer.codeElements;

import static code_analyzer.codeElements.CodeElementType.TABLE;

import code_analyzer.Configuration;
import code_analyzer.Expression;

public class NameGiver {
	Configuration configuration;

	public NameGiver(Configuration configuration) {
		this.configuration = configuration;
	}

	public String getNameFor(Expression expression) {
		if (expression.getType() == TABLE)
			return getNameForTable(expression);
		else
			return "";

	}

	private String getNameForTable(Expression expression) {
		String result1[], result2[];
		int i = 0;
		result1 = expression.toString().split(configuration.getProperty("tableKeyword"));
		result2 = result1[1].split(",");
		for (i = 0; i < result2.length; i++) {
			result2[i] = result2[i].trim();
		}
		StringBuffer stringBuffer = new StringBuffer(result2[0]);
		stringBuffer.deleteCharAt(0);
		result2[0] = stringBuffer.toString();

		int lastSymbol = result2[2].length() - 1;
		stringBuffer = new StringBuffer(result2[2]);
		stringBuffer.deleteCharAt(lastSymbol);
		result2[2] = stringBuffer.toString();
		return result2[0];
		// FIXME wrong name
	}

}
