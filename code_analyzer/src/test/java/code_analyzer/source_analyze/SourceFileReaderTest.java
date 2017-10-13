package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.Test;

public class SourceFileReaderTest {

	@Test
	public void isEmptyTest() throws FileNotFoundException {
		SourceFileReader sourceFileReader = new SourceFileReader(new BufferedReader(new StringReader("abcdef")));
		boolean res = false;
		int charCount = 6;
		for (int i = 0; i < charCount; i++) {
			res = sourceFileReader.isEmpty();
		}
		assertTrue("expected to be still false", res == false);
		res = sourceFileReader.isEmpty();
		assertTrue("expected to be already true", res == true);
	}

	@Test
	public void getNextCharTest() throws FileNotFoundException {
		SourceFileReader sourceFileReader = new SourceFileReader(new BufferedReader(new StringReader("abcdef")));
		boolean res = false;
		int charCount = 5;
		char achar = 0;
		for (int i = 0; i < charCount; i++) {
			if (!sourceFileReader.isEmpty()) {
				achar = sourceFileReader.getNextChar();
			}
		}
		assertTrue("expected to be 'e', but is " + achar, achar == 'e');
		if (!sourceFileReader.isEmpty()) {
			achar = sourceFileReader.getNextChar();
		}
		assertTrue("expected to be 'f', but is " + achar, achar == 'f');
	}

}
