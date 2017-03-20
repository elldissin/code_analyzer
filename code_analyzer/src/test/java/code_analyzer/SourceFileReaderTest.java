package code_analyzer;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SourceFileReaderTest {

	@Test
	public void readLineTest() {
		SourceFileReader readerTest = new SourceFileReader();
		String result;
		result = readerTest.readLine();
		assertTrue("Wrong string read from file", result.equals("MyCodeLine(hello);"));
	}

}
