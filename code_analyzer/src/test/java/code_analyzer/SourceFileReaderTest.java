package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SourceFileReaderTest {

	@Test
	public void readFileContentTest() {
		String result = new String();
		String expected = new String();

		expected = "MyCodeLine(hello);" + "MyCodeAnotherLine(bye);" + "ThirdLine(third);";
		result = SourceFileReader.readFileContent("file.txt");
		assertTrue("Wrong string read from file:" + result, result.equals(expected));
	}

}
