package code_analyzer.source_analyze;

import java.io.IOException;
import java.io.Reader;

/**
 * Represents a single code source, which can be either file or another source
 * extending the Reader class. It also stores the detailed information about the
 * source.
 */
public class CodeSource {

	private Reader reader;
	private String nameOfReader;

	public CodeSource(Reader reader, String nameOfReader) {
		this.reader = reader;
		this.nameOfReader = nameOfReader;

	}

	public int read() {
		int result = -1;
		try {
			result = reader.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String getNameOfReader() {
		return nameOfReader;
	}

}
