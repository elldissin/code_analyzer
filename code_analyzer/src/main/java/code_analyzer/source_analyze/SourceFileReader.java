package code_analyzer.source_analyze;

public class SourceFileReader {
	private CodeSource codeSource;
	private int currentLine;

	public SourceFileReader(CodeSource codeSource) {
		this.codeSource = codeSource;
	}

	public int getNextChar() {
		int lastReadChar = -1;
		lastReadChar = codeSource.read();
		while (lastReadChar == '\r' || lastReadChar == '\n') {
			if (lastReadChar == '\n') {
				currentLine++;
			}
			lastReadChar = codeSource.read();
		}
		return lastReadChar;
	}

	public int getCurLineNum() {
		return currentLine + 1;
	}

	public String getCurFileName() {
		return codeSource.getNameOfReader();
	}
}
