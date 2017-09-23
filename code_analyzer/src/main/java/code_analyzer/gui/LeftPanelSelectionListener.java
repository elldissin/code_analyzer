package code_analyzer.gui;

import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class LeftPanelSelectionListener implements ListSelectionListener {
	WindowPanel windowPanel;
	ContentPanel contentPanel;

	LeftPanelSelectionListener(ContentPanel contentPanel) {
		this.windowPanel = contentPanel.windowPanel;
		this.contentPanel = contentPanel;
	}

	public void valueChanged(ListSelectionEvent e) {
		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 0) {
			String name = (String) windowPanel.contentPanel.leftPanelJList.getSelectedValue();
			int i = contentPanel.dBStructure.getIndexByName(name);
			windowPanel.contentPanel.fieldList.setText("<html>");
			String FieldNames;
			for (int j = 0; j < contentPanel.dBStructure.getTableList().get(i).getChildList().size(); j++) {
				FieldNames = contentPanel.dBStructure.getTableList().get(i).getChildList().get(j).getName();
				windowPanel.contentPanel.fieldList
						.setText(windowPanel.contentPanel.fieldList.getText() + FieldNames + "<br>");
			}
			windowPanel.statusPanel.info3
					.setText("Path:" + contentPanel.dBStructure.getTableList().get(i).getfileName());
		}
		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 1) {
			String name = (String) windowPanel.contentPanel.leftPanelJList.getSelectedValue();
			windowPanel.contentPanel.fieldList.setText("<html>");
			String tableName;
			List<String> tablesNames = contentPanel.dBStructure.getTablesByFieldName(name);
			windowPanel.statusPanel.info3.setText("<html>Path:");
			for (int i = 0; i < tablesNames.size(); i++) {
				tableName = tablesNames.get(i);
				windowPanel.contentPanel.fieldList
						.setText(windowPanel.contentPanel.fieldList.getText() + tableName + "<br>");

				windowPanel.statusPanel.info3.setText(windowPanel.statusPanel.info3.getText()
						+ contentPanel.dBStructure.getTableList()
								.get(contentPanel.dBStructure.getIndexByName(tablesNames.get(i))).getfileName()
						+ "<br>");
			}
		}
	}
}
