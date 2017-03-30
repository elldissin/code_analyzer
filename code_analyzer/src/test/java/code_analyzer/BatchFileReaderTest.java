package code_analyzer;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BatchFileReaderTest {

	@Test
	public void readFilesContentTest() {
		BatchFileReader testBatchReader = new BatchFileReader();
		String result = new String();
		String expected = new String();
		List<File> fileListTest = new ArrayList<File>();
		fileListTest.add(new File("file.txt"));
		fileListTest.add(new File("file2.txt"));
		expected = "MyCodeLine(hello);" + "MyCodeAnotherLine(bye);" + "ThirdLine(third);" + "LineFromFile2(hello);";
		result = testBatchReader.readFilesContent(fileListTest);

		assertTrue("Wrong text read from one or several files", result.equals(expected));
	}

}
