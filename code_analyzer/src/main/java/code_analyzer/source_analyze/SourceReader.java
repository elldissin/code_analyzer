package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class SourceReader {
	private List<SourceFileReader> sourceFileReaderList;
	private int currentFileIndex;

	public SourceReader(List<BufferedReader> bufferedReadersList) {
		sourceFileReaderList = new ArrayList<SourceFileReader>();
		for (int i = 0; i < bufferedReadersList.size(); i++) {
			SourceFileReader sourceFileReader;
			sourceFileReader = new SourceFileReader(bufferedReadersList.get(i));
			sourceFileReaderList.add(sourceFileReader);
		}
	}

	public int getNextChar() {
		int achar;
		if (currentFileIndex >= sourceFileReaderList.size()) {
			return (char) (-1);
		}
		achar = sourceFileReaderList.get(currentFileIndex).getNextChar();
		if (achar == -1) {
			currentFileIndex++;
			if (currentFileIndex >= sourceFileReaderList.size()) {
				return (char) (-1);
			}
			return getNextChar();
		}
		return achar;
	}
}
