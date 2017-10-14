package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.util.List;

public class ExpressionScanner {
	private SourceReader sourceReader;
	private boolean isEmpty;

	public ExpressionScanner(List<BufferedReader> bufferedReadersList) {
		sourceReader = new SourceReader(bufferedReadersList);
	}

	public Expression getNextExpression() {
		String expressionString = "";
		int achar = sourceReader.getNextChar();
		while (achar != ';') {
			if (achar == -1) {
				isEmpty = true;
				return new Expression("");
			}
			expressionString = expressionString + (char) achar;
			achar = sourceReader.getNextChar();
		}
		return new Expression(expressionString.trim());
	}

	public boolean isEmpty() {
		return isEmpty;
	}
}
