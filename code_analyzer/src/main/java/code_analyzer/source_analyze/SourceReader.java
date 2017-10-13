package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.io.File;
import java.util.List;

public class SourceReader {
	private SourceFolderScanner sourceFolderScanner;
	private List<SourceFileReader> sourceFileReaderList;
	private List<File> sourceFilesList;
	private int currentFileIndex;

	public SourceReader(List<BufferedReader> bufferedReadersList) {
		for (int i = 0; i < bufferedReadersList.size(); i++) {
			SourceFileReader sourceFileReader;
			sourceFileReader = new SourceFileReader(bufferedReadersList.get(currentFileIndex));
			sourceFileReaderList.add(sourceFileReader);
		}
	}

	public char getNextChar() {
		char achar;
		achar = sourceFileReaderList.get(currentFileIndex).getNextChar();
		if ((int) (achar) == -1) {
			currentFileIndex++;
			if (currentFileIndex >= sourceFilesList.size()) {
				return (char) (-1);
			}
			return getNextChar();
		}
		return achar;
	}
}
