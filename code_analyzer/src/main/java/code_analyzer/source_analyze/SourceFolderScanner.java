package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SourceFolderScanner {
	final File folder;
	private List<File> foundFileList;

	public SourceFolderScanner(String folderPath) {
		folder = new File(folderPath);
		foundFileList = new ArrayList<File>();
		scanFolder(folder);
	}

	private void scanFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				scanFolder(fileEntry);
			} else {
				if (fileEntry.getName().toLowerCase().endsWith(Configuration.getProperty("targetfiletype")))
					if (!fileEntry.getName().toLowerCase().endsWith("config.txt")) {
						foundFileList.add(fileEntry);
					}
			}
		}
	}

	public List<File> getFileList() {
		return foundFileList;
	}

	public List<BufferedReader> getBufferedReadersList() {
		List<BufferedReader> bufferedReadersList = new ArrayList<BufferedReader>();
		for (int i = 0; i < foundFileList.size(); i++) {
			try {
				bufferedReadersList.add(new BufferedReader(new FileReader(foundFileList.get(i))));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bufferedReadersList;
	}
}
