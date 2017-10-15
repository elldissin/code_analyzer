package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Scans the folder for existing source files and can transform them into higher
 * level representation class for more convenient use
 *
 */
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
				// scanFolder(fileEntry);
			} else {
				if (fileEntry.getName().toLowerCase().endsWith(Configuration.getProperty("targetfiletype")))
					foundFileList.add(fileEntry);
			}
		}
	}

	public List<File> getFileList() {
		return foundFileList;
	}

	public List<CodeSource> getCodeSourcesList() {
		List<CodeSource> codeSourcesList = new ArrayList<CodeSource>();
		CodeSource codeSource;
		FileReader fileReader;
		Reader reader;
		for (int i = 0; i < foundFileList.size(); i++) {
			try {
				fileReader = new FileReader(foundFileList.get(i));
				reader = new BufferedReader(fileReader);
				codeSource = new CodeSource(reader, foundFileList.get(i).getName());
				codeSourcesList.add(codeSource);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return codeSourcesList;
	}
}
