package code_analyzer.gui;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableListSelectionListener implements ListSelectionListener {
	ContentPanel contentPanel;

	TableListSelectionListener(ContentPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

	public void valueChanged(ListSelectionEvent e) {
		{
			String s = (String) contentPanel.tableJList.getSelectedValue();
			contentPanel.fieldList.setText(s + " Field list:");

		}

	}
}
