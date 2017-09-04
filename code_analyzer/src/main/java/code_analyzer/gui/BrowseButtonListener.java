package code_analyzer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import code_analyzer.db_elements.DBElement;
import code_analyzer.db_elements.DBStructure;
import code_analyzer.source_analyze.BatchFileReader;
import code_analyzer.source_analyze.ExpressionAnalyzer;
import code_analyzer.source_analyze.ExpressionScanner;
import code_analyzer.source_analyze.SourceFolderScanner;

public class BrowseButtonListener implements ActionListener {
	MenuPanel menuPanel;
	SourceFolderScanner sourceFolderScanner;
	BatchFileReader batchFileReader = new BatchFileReader();
	List<String> tableList = new ArrayList<String>();
	ContentPanel contentPanel;

	public BrowseButtonListener(MenuPanel menuPanel, ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
		this.menuPanel = menuPanel;
	}

	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setCurrentDirectory(new File("."));
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(menuPanel);
		DBStructure dBStructure = new DBStructure();
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			sourceFolderScanner = new SourceFolderScanner(chooser.getSelectedFile().getPath());
			String result = batchFileReader.readFilesContent(sourceFolderScanner.getFileList());
			ExpressionScanner expressionScanner = new ExpressionScanner(result);
			ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
			while (!expressionScanner.isEmpty()) {
				DBElement dBElement = expressionAnalyzer.makeDBElement(expressionScanner.getNextExpression());
				if (dBElement != null) {
					dBStructure.putCodeElement(dBElement);
				}
			}
			for (int i = 0; i < dBStructure.getTableList().size(); i++) {
				tableList.add(dBStructure.getTableList().get(i).getName());
			}

		}
		contentPanel.setNewTableList(this.getTableList());
		contentPanel.tree.setDB(dBStructure);

	}

	public List<String> getTableList() {
		return tableList;
	}

}
