package code_analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SourceFolderScanner {
	final File folder = new File(".");
	private List<File> foundFileList;

	public SourceFolderScanner() {
		foundFileList = new ArrayList<File>();
	}

	private void scanFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				scanFolder(fileEntry);
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