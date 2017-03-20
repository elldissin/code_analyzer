package code_analyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SourceFileReader {
	public String readLine() {
		String lastReadLine = new String();
		BufferedReader Reader;
		try {
			Reader = new BufferedReader(new FileReader("file.txt"));
			lastReadLine = Reader.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastReadLine;
	}
}
