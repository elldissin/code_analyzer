package code_analyzer.source_analyze;

import java.io.File;
import java.util.List;

public class BatchFileReader {
	List<File> fileList;
	File fileName;
	int fileIndex;

	public String getCurrentFileName(int i) {
		String name = fileList.get(i).getName();
		return name;
	}

	public String readFilesContent(final List<File> fileList) {
		this.fileList = fileList;
		String result = new String();
		fileName = fileList.get(fileIndex);
		if (fileName.exists()) {
			result = SourceFileReader.readFileContent(fileName.getPath());
			fileIndex++;
		}
		return result;
	}

	public void setFileIndex(int fileIndex) {
		this.fileIndex = fileIndex;
	}
}
