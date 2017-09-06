package code_analyzer.gui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableListSelectionListener implements ListSelectionListener {
	WindowPanel windowPanel;
	ContentPanel contentPanel;

	TableListSelectionListener(ContentPanel contentPanel) {
		this.windowPanel = contentPanel.windowPanel;
		this.contentPanel = contentPanel;
	}

	public void valueChanged(ListSelectionEvent e) {
		{
			String s = (String) windowPanel.contentPanel.tableJList.getSelectedValue();
			int i = windowPanel.contentPanel.tableJList.getSelectedIndex();
			windowPanel.contentPanel.fieldList.setText("<html>");
			String FieldNames;
			for (int j = 0; j < contentPanel.dBStructure.getTableList().get(i).getChildList().size(); j++) {
				FieldNames = contentPanel.dBStructure.getTableList().get(i).getChildList().get(j).getName();
				windowPanel.contentPanel.fieldList
						.setText(windowPanel.contentPanel.fieldList.getText() + FieldNames + "<br>");
			}

		}

	}
}
