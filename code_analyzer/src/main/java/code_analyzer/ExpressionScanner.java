package code_analyzer;

public class ExpressionScanner {
	String fullString;
	String result[];
	int i = 0;

	// FIXME rework to class hierarchy
	ExpressionScanner(final String fullString) {
		this.fullString = fullString;
		result = fullString.split(";");
	}

	public String getNextExpression() {

		String nextExpression = "";
		if (i < result.length) {
			nextExpression = result[i];
			i++;
			nextExpression = nextExpression.replaceAll("[\\s]+", " ");
			nextExpression = nextExpression.trim();
		}
		return nextExpression;
		// for(int i = 0; i<result.length;i++){
		// nextExpression=result[i];
		// System.out.println(NextExpression);
		// }

	}
}
