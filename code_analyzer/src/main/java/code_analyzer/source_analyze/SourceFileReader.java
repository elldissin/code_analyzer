package code_analyzer.source_analyze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SourceFileReader {
	private BufferedReader reader;
	private int lastReadChar;

	public SourceFileReader(BufferedReader reader) {
		this.reader = reader;
	}

	public static String readFileContent(String fileName) {
		String lastReadLine = new String();
		String wholeFile = new String();
		BufferedReader Reader;
		try {
			Reader = new BufferedReader(new FileReader(fileName));
			while ((lastReadLine = Reader.readLine()) != null) {
				wholeFile = wholeFile + lastReadLine;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wholeFile;
	}

	public char getNextChar() {
		try {
			lastReadChar = reader.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (char) (lastReadChar);
	}
}
