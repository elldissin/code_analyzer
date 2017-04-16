package code_analyzer;

public class ExpressionScanner {
	String fullString;
	String result[];
	int i = 0;
	Configuration configuration;

	public ExpressionScanner(final String fullString, Configuration configuration) {
		this.configuration = configuration;
		this.fullString = fullString;
		result = fullString.split(";");
	}

	public Expression getNextExpression() {

		String tempString = "";
		tempString = result[i];
		i++;
		tempString = tempString.replaceAll("[\\s]+", " ");
		tempString = tempString.trim();

		Expression nextExpression = new Expression(tempString, configuration);
		return nextExpression;

	}

	public boolean isEmpty() {
		if (i < result.length) {
			return false;
		}
		return true;
	}

}
