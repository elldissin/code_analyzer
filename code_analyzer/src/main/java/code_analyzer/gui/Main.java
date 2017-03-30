package code_analyzer.gui;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

import code_analyzer.BatchFileReader;
import code_analyzer.SourceFolderScanner;

public class Main {

	public static void main(String[] args) {

		JPanel jPanel = new JPanel();
		JFileChooser chooser = new JFileChooser();
		SourceFolderScanner sourceFolderScanner;
		BatchFileReader batchFileReader = new BatchFileReader();

		// FileNameExtensionFilter filter = new FileNameExtensionFilter("txt
		// only", "txt");
		// chooser.setFileFilter(filter);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(jPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			sourceFolderScanner = new SourceFolderScanner(chooser.getSelectedFile().getPath());
			String result = batchFileReader.readFilesContent(sourceFolderScanner.getFileList());
			System.out.println(result);
		}

	}
}
