package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.io.IOException;

public class SourceFileReader {
	private BufferedReader reader;
	private int currentLine;

	public SourceFileReader(BufferedReader reader) {
		this.reader = reader;
	}

	public int getNextChar() {
		int lastReadChar = -1;
		try {
			lastReadChar = reader.read();
			while (lastReadChar == '\r' || lastReadChar == '\n') {
				if (lastReadChar == '\n') {
					currentLine++;
				}
				lastReadChar = reader.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastReadChar;
	}

	public int getCurLineNum() {
		return currentLine + 1;
	}
}
