package code_analyzer.gui;

import java.awt.Color;
import java.util.List;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LeftPanelSelectionListener implements ListSelectionListener {
	WindowPanel windowPanel;
	ContentPanel contentPanel;
	String middlePanelString[];

	LeftPanelSelectionListener(ContentPanel contentPanel) {
		this.windowPanel = contentPanel.windowPanel;
		this.contentPanel = contentPanel;
	}

	public void valueChanged(ListSelectionEvent e) {
		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 0) {
			String name = (String) windowPanel.contentPanel.leftPanelJList.getSelectedValue();
			int i = contentPanel.dBStructure.getIndexByName(name);
			middlePanelString = new String[contentPanel.dBStructure.getTableList().get(i).getChildList().size()];
			for (int j = 0; j < contentPanel.dBStructure.getTableList().get(i).getChildList().size(); j++) {
				middlePanelString[j] = contentPanel.dBStructure.getTableList().get(i).getChildList().get(j).getName();
			}
			windowPanel.statusPanel.info3
					.setText("Path:" + contentPanel.dBStructure.getTableList().get(i).getfileName());
		}
		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 1) {
			String name = (String) windowPanel.contentPanel.leftPanelJList.getSelectedValue();
			String tableName;
			List<String> tablesNames = contentPanel.dBStructure.getTablesByFieldName(name);
			windowPanel.statusPanel.info3.setText("<html>Path:");
			middlePanelString = new String[tablesNames.size()];
			for (int i = 0; i < tablesNames.size(); i++) {
				tableName = tablesNames.get(i);
				middlePanelString[i] = tableName;

				windowPanel.statusPanel.info3.setText(windowPanel.statusPanel.info3.getText()
						+ contentPanel.dBStructure.getTableList()
								.get(contentPanel.dBStructure.getIndexByName(tablesNames.get(i))).getfileName()
						+ "<br>");
			}
		}
		contentPanel.remove(contentPanel.middlePanel);
		contentPanel.middlePanelJList = new JList(middlePanelString);
		contentPanel.middlePanel = new JScrollPane(contentPanel.middlePanelJList);
		contentPanel.add(contentPanel.middlePanel, 1);
		contentPanel.middlePanelJList.setForeground(Color.GREEN);
		contentPanel.middlePanelJList.setBackground(Color.BLACK);
		contentPanel.repaint();
		contentPanel.revalidate();

	}
}
