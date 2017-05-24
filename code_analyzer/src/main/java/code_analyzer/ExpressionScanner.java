package code_analyzer;

public class ExpressionScanner {
	String fullString;
	String result[];
	int i = 0;

	public ExpressionScanner(final String fullString) {
		this.fullString = fullString;
		result = fullString.split(";");
	}

	public Expression getNextExpression() {

		String tempString = "";
		tempString = result[i];
		i++;
		tempString = tempString.replaceAll("[\\s]+", " ");
		tempString = tempString.trim();

		Expression nextExpression = new Expression(tempString);
		return nextExpression;

	}

	public boolean isEmpty() {
		if (i < result.length) {
			return false;
		}
		return true;
	}

}
