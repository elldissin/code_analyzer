package code_analyzer.gui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableListSelectionListener implements ListSelectionListener {
	WindowPanel windowPanel;

	TableListSelectionListener(WindowPanel windowPanel) {
		this.windowPanel = windowPanel;
	}

	public void valueChanged(ListSelectionEvent e) {
		{
			String s = (String) windowPanel.contentPanel.tableJList.getSelectedValue();
			windowPanel.contentPanel.fieldList.setText(s + " Field list:");
		}

	}
}
