package code_analyzer.source_analyze;

import java.io.File;
import java.util.List;

public class BatchFileReader {
	List<File> fileList;

	public String readFilesContent(final List<File> fileList) {
		this.fileList = fileList;
		String result = new String();
		for (int i = 0; i < fileList.size(); i++) {
			File fileName = fileList.get(i);
			if (fileName.exists()) {
				result = result + SourceFileReader.readFileContent(fileName.getPath());
			}
		}
		return result;
	}
}
