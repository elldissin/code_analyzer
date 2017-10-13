package code_analyzer.source_analyze;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SourceReaderTest {

	@Test
	public void getNextCharTest() {
		int achar = -1;
		List<BufferedReader> bufferedReadersList = new ArrayList<BufferedReader>();
		bufferedReadersList.add(new BufferedReader(new StringReader("abcdef")));
		bufferedReadersList.add(new BufferedReader(new StringReader("ghijkl")));
		bufferedReadersList.add(new BufferedReader(new StringReader("mnhp")));
		bufferedReadersList.add(new BufferedReader(new StringReader("rstuf")));
		SourceReader sourceReader = new SourceReader(bufferedReadersList);
		for (int i = 0; i < 12; i++) {
			achar = sourceReader.getNextChar();
		}
		assertTrue("expected 'l', but got " + achar, achar == 'l');
		for (int i = 0; i < 4; i++) {
			achar = sourceReader.getNextChar();
		}
		assertTrue("expected 'p', but got " + achar, achar == 'p');
		for (int i = 0; i < 5; i++) {
			achar = sourceReader.getNextChar();
		}
		assertTrue("expected 'f', but got " + achar, achar == 'f');
		achar = sourceReader.getNextChar();
		assertTrue("expected '0xFFFF', but got " + achar, achar == 0xFFFF);

	}

}
