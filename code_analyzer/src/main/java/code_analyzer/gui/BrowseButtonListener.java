package code_analyzer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;

import code_analyzer.BatchFileReader;
import code_analyzer.Configuration;
import code_analyzer.ExpressionAnalyzer;
import code_analyzer.ExpressionScanner;
import code_analyzer.SourceFolderScanner;
import code_analyzer.codeElements.DBElement;
import code_analyzer.codeElements.DBStructureMaker;

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
		Configuration configuration = new Configuration();
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setCurrentDirectory(new File("."));
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(menuPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			sourceFolderScanner = new SourceFolderScanner(chooser.getSelectedFile().getPath());
			String result = batchFileReader.readFilesContent(sourceFolderScanner.getFileList());
			ExpressionScanner expressionScanner = new ExpressionScanner(result, configuration);
			ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer(configuration);
			DBStructureMaker dBStructureMaker = new DBStructureMaker();
			while (!expressionScanner.isEmpty()) {
				DBElement dBElement = expressionAnalyzer.makeCodeElement(expressionScanner.getNextExpression());
				if (dBElement != null) {
					dBStructureMaker.putCodeElement(dBElement);
				}
			}
			for (int i = 0; i < dBStructureMaker.getTableList().size(); i++) {
				tableList.add(dBStructureMaker.getTableList().get(i).getName());
			}

		}
		for (int i = 0; i < tableList.size(); i++) {
			DefaultMutableTreeNode lvl2node = new DefaultMutableTreeNode(tableList.get(i));
			contentPanel.tree.lvl1node.add(lvl2node);
		}

	}

	public List<String> getTableList() {
		return tableList;
	}

}
