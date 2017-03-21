package code_analyzer;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.Test;

public class SourceFolderScannerTest {

	@Test
	public void getFileListTest() {
		SourceFolderScanner folderScannerTest = new SourceFolderScanner();
		List<File> resultFileListTest;
		boolean allFilesAreTxt = true;

		resultFileListTest = folderScannerTest.getFileList();

		assertTrue("File list is NULL", resultFileListTest != null);
		for (int i = 0; i < resultFileListTest.size(); i++) {
			if (!resultFileListTest.get(i).getName().toLowerCase().endsWith(".txt")) {
				allFilesAreTxt = false;
				break;
			}
		}
		assertTrue("Not all found files are TXT", allFilesAreTxt);
	}

}
