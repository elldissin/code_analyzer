package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SourceFileReaderTest {

	@Test
	public void readFileContentTest() {
		String result = new String();
		String expected = new String();

		expected = "tableStart(Name1, 0, \" \");" + "tableStart(Name2, 1, \" 11 \");"
				+ "tableStart(Name3Vivaldi, 1, \" 11 \");";
		result = SourceFileReader.readFileContent("file3.txt");
		assertTrue("Wrong string read from file:" + result, result.equals(expected));
	}

}
