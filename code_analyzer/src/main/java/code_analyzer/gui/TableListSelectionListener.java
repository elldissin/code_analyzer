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
			// FIXME needed to make new lines
			int i = windowPanel.contentPanel.tableJList.getSelectedIndex();

			String FieldNames = " ";
			for (int j = 0; j < contentPanel.dBStructure.getTableList().get(i).getChildList().size(); j++) {
				FieldNames = FieldNames + "   "
						+ contentPanel.dBStructure.getTableList().get(i).getChildList().get(j).getName();
			}
			windowPanel.contentPanel.fieldList.setText(FieldNames);
		}

	}
}
