package code_analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SourceFolderScanner {
	final File folder;
	private List<File> foundFileList;

	public SourceFolderScanner(String folderPath) {
		folder = new File(folderPath);
		foundFileList = new ArrayList<File>();
	}

	private void scanFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				// scanFolder(fileEntry); //TODO errors on recursion
			} else {
				if (fileEntry.getName().toLowerCase().endsWith(".txt"))
					foundFileList.add(fileEntry);
			}
		}
	}

	public List<File> getFileList() {
		scanFolder(folder);
		return foundFileList;
	}
}
