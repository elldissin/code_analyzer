package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.util.List;

public class ExpressionScanner {
	private SourceReader sourceReader;

	public ExpressionScanner(List<BufferedReader> bufferedReadersList) {
		sourceReader = new SourceReader(bufferedReadersList);
	}

	public Expression getNextExpression() {
		String expressionString = "";
		int achar = sourceReader.getNextChar();
		while (achar != ';') {
			if (achar == -1) {
				return new Expression("");
			}
			expressionString = expressionString + (char) achar;
			achar = sourceReader.getNextChar();
		}
		return new Expression(expressionString);
	}
}
