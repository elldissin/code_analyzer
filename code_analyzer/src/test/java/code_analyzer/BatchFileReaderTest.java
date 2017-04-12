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
		fileListTest.add(new File("file3.txt"));
		expected = "tableStart(Name1, 0, \" \");" + "tableStart(Name2, 1, \" 11 \");"
				+ "tableStart(Name3Vivaldi, 1, \" 11 \");";
		result = testBatchReader.readFilesContent(fileListTest);

		assertTrue("Wrong text read by BatchFileReader:" + result, result.equals(expected));
	}

}
