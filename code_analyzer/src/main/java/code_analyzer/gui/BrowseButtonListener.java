package code_analyzer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import code_analyzer.db_elements.DBElement;
import code_analyzer.db_elements.DBStructure;
import code_analyzer.source_analyze.Expression;
import code_analyzer.source_analyze.ExpressionScanner;
import code_analyzer.source_analyze.SourceFolderScanner;

public class BrowseButtonListener implements ActionListener {
	MenuPanel menuPanel;
	SourceFolderScanner sourceFolderScanner;
	private List<String> tableList = new ArrayList<String>();
	private List<String> fieldList = new ArrayList<String>();
	ContentPanel contentPanel;
	DBStructure dBStructure;

	public BrowseButtonListener(MenuPanel menuPanel, ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
		this.menuPanel = menuPanel;
		this.dBStructure = contentPanel.dBStructure;
	}

	public void actionPerformed(ActionEvent e) {
		dBStructure.clear();
		tableList.clear();
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setCurrentDirectory(new File("."));
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(menuPanel);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			SourceFolderScanner sourceFolderScanner = new SourceFolderScanner(chooser.getSelectedFile().getPath());
			ExpressionScanner expressionScanner = new ExpressionScanner(sourceFolderScanner.getBufferedReadersList());
			Expression expression = expressionScanner.getNextExpression();
			while (!expressionScanner.isEmpty()) {
				DBElement dBElement = expression.toDBElement();
				// dBElement.setfileName(batchFileReader.getCurrentFileName(i));
				if (dBElement != null) {
					dBStructure.addDBElement(dBElement);
				}
				expression = expressionScanner.getNextExpression();
			}
			for (int i = 0; i < dBStructure.getTableList().size(); i++) {
				tableList.add(dBStructure.getTableList().get(i).getName());
			}
			for (int i = 0; i < dBStructure.getFieldList().size(); i++) {
				fieldList.add(dBStructure.getFieldList().get(i).getName());
			}
		}
		contentPanel.setNewLeftPanelList(getTableList());
		contentPanel.tree.setDB(dBStructure);

	}

	public List<String> getTableList() {
		return tableList;
	}

	public List<String> getFieldList() {
		return fieldList;
	}
}
