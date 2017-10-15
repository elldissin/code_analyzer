package code_analyzer.source_analyze;

import java.util.List;

public class ExpressionScanner {
	private SourceReader sourceReader;
	private boolean isEmpty;

	public ExpressionScanner(List<CodeSource> codeSourcesList) {
		sourceReader = new SourceReader(codeSourcesList);
	}

	public Expression getNextExpression() {
		String expressionString = "";
		Expression expression;
		int achar = sourceReader.getNextChar();
		while (achar != ';') {
			if (achar == -1) {
				isEmpty = true;
				return new Expression("");
			}
			expressionString = expressionString + (char) achar;
			achar = sourceReader.getNextChar();
		}
		expression = new Expression(expressionString.trim());
		String locationInfo = "File: " + sourceReader.getCurFileString() + ", Line: " + sourceReader.getCurLineString();
		expression.setLocationInfo(locationInfo);
		return expression;
	}

	public boolean isEmpty() {
		return isEmpty;
	}
}
