package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BatchFileReaderTest {

	@Test
	public void readFilesContentTest() {
		BatchFileReader testBatchReader = new BatchFileReader();
		SourceFolderScanner testFolderScanner = new SourceFolderScanner();
		String result = new String();
		String expected = new String();

		expected = "MyCodeLine(hello);" + "MyCodeAnotherLine(bye);" + "ThirdLine(third);" + "LineFromFile2(hello);";
		result = testBatchReader.readFilesContent(testFolderScanner.getFileList());

		assertTrue("Wrong text read from one or several files", result.equals(expected));
	}

}
