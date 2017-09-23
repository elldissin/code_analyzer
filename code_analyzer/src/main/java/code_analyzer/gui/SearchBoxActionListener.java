package code_analyzer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBoxActionListener implements ActionListener {
	WindowPanel windowPanel;

	SearchBoxActionListener(WindowPanel windowPanel) {
		this.windowPanel = windowPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 0) {
			windowPanel.contentPanel.setNewLeftPanelList(windowPanel.menuPanel.browseButtonListener.getTableList());
		}
		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 1) {
			for (int i = 0; i < windowPanel.contentPanel.dBStructure.getFieldList().size(); i++) {
				windowPanel.contentPanel.setNewLeftPanelList(windowPanel.menuPanel.browseButtonListener.getFieldList());
			}
		}

	}

}
