package code_analyzer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SourceFileMaker {
	SourceFileMaker() {
		String fileSource = SourceFileReader.readFileContent("file.txt");
		String newText = "\r\n" + "ururu"; // System.getProperty("line.separator")
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("result.txt"));
			bufferedWriter.write(fileSource + newText);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
