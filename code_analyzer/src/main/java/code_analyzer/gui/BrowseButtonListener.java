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
	DBStructure dBStructure;

	public BrowseButtonListener(MenuPanel menuPanel, ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
		this.menuPanel = menuPanel;
		this.dBStructure = contentPanel.dBStructure;
	}

	public void actionPerformed(ActionEvent e) {
		batchFileReader.setFileIndex(0);
		dBStructure.clear();
		tableList.clear();
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setCurrentDirectory(new File("."));
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(menuPanel);
		// DBStructure dBStructure = new DBStructure();
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			sourceFolderScanner = new SourceFolderScanner(chooser.getSelectedFile().getPath());
			ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer();
			List<File> tempFileList = sourceFolderScanner.getFileList();
			for (int i = 0; i < tempFileList.size(); i++) {
				String result = batchFileReader.readFilesContent(tempFileList);
				ExpressionScanner expressionScanner = new ExpressionScanner(result);
				while (!expressionScanner.isEmpty()) {
					DBElement dBElement = expressionAnalyzer.makeDBElement(expressionScanner.getNextExpression());
					dBElement.setfileName(batchFileReader.getCurrentFileName(i));
					if (dBElement != null) {
						dBStructure.putCodeElement(dBElement);
					}
				}
			}
			for (int j = 0; j < dBStructure.getTableList().size(); j++) {
				tableList.add(dBStructure.getTableList().get(j).getName());
			}
			System.out.println(tableList.size());
		}
		contentPanel.setNewTableList(getTableList());
		contentPanel.tree.setDB(dBStructure);

	}

	public List<String> getTableList() {
		return tableList;
	}

}
