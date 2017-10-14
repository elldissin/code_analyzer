package code_analyzer.source_analyze;

import java.util.ArrayList;
import java.util.List;

public class SourceReader {
	private List<SourceFileReader> sourceFileReaderList;
	private int currentFileIndex;

	public SourceReader(List<CodeSource> codeSourcesList) {
		sourceFileReaderList = new ArrayList<SourceFileReader>();
		for (int i = 0; i < codeSourcesList.size(); i++) {
			SourceFileReader sourceFileReader;
			sourceFileReader = new SourceFileReader(codeSourcesList.get(i));
			sourceFileReaderList.add(sourceFileReader);
		}
	}

	public int getNextChar() {
		int achar;
		if (currentFileIndex >= sourceFileReaderList.size()) {
			return -1;
		}
		achar = sourceFileReaderList.get(currentFileIndex).getNextChar();
		if (achar == -1) {
			currentFileIndex++;
			if (currentFileIndex >= sourceFileReaderList.size()) {
				return -1;
			}
			return getNextChar();
		}
		return achar;
	}

	public String getCurLineString() {
		return String.valueOf(sourceFileReaderList.get(currentFileIndex).getCurLineNum());
	}

	public String getCurFileString() {
		return sourceFileReaderList.get(currentFileIndex).getCurFileName();
	}
}
