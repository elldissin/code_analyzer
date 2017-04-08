package code_analyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Configuration {
	private String tableKeyWord;
	private String modifierKeyWord;
	private String fieldKeyWord;
	private String fieldPropertyKeyWord;
	private BufferedReader configReader;
	private boolean loaded;

	public Configuration() {
		loaded = false;
		try {
			configReader = new BufferedReader(new FileReader("config.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tableKeyWord = configReader.readLine();
			modifierKeyWord = configReader.readLine();
			fieldKeyWord = configReader.readLine();
			fieldPropertyKeyWord = configReader.readLine();
			loaded = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isLoaded() {
		return loaded;
	}

	public String getTableKeyword() {
		return tableKeyWord;
	}

	public String getFieldKeyword() {
		return fieldKeyWord;
	}

	public String getModifierKeyword() {
		return modifierKeyWord;
	}

	public String getFieldPropertyKeyWord() {
		return fieldPropertyKeyWord;
	}

}
