package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.Test;

public class SourceFileReaderTest {

	@Test
	public void getNextCharTest() throws FileNotFoundException {
		SourceFileReader sourceFileReader = new SourceFileReader(
				new CodeSource(new BufferedReader(new StringReader("abcdef")), "teststream"));
		boolean res = false;
		int charCount = 5;
		int achar = -1;
		for (int i = 0; i < charCount; i++) {
			achar = sourceFileReader.getNextChar();
		}
		assertTrue("expected to be 'e', but is " + achar, achar == 'e');
		achar = sourceFileReader.getNextChar();
		assertTrue("expected to be 'f', but is " + achar, achar == 'f');
	}

}
