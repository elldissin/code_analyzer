package code_analyzer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import code_analyzer.BatchFileReader;
import code_analyzer.SourceFolderScanner;

public class BrowseButtonListener implements ActionListener {
	MenuPanel menuPanel;
	SourceFolderScanner sourceFolderScanner;
	BatchFileReader batchFileReader = new BatchFileReader();

	public BrowseButtonListener(MenuPanel menuPanel) {

		this.menuPanel = menuPanel;
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setCurrentDirectory(new File("."));
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(menuPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			sourceFolderScanner = new SourceFolderScanner(chooser.getSelectedFile().getPath());
			String result = batchFileReader.readFilesContent(sourceFolderScanner.getFileList());
			System.out.println(result);
		}

	}

}
