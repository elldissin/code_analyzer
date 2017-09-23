package code_analyzer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchButtonListener implements ActionListener {
	WindowPanel windowPanel;

	SearchButtonListener(WindowPanel windowPanel) {
		this.windowPanel = windowPanel;
	}

	public void actionPerformed(ActionEvent e) {
		List<String> searchList = new ArrayList<String>();
		List<String> findedList = new ArrayList<String>();
		String searchExpression = ".*" + windowPanel.menuPanel.searchField.getText() + ".*";

		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 0) {
			searchList = windowPanel.menuPanel.browseButtonListener.getTableList();
		}
		if (windowPanel.menuPanel.searchBox.getSelectedIndex() == 1) {
			searchList = windowPanel.menuPanel.browseButtonListener.getFieldList();
		}
		for (int i = 0; i < searchList.size(); i++) {
			if (searchList.get(i).toLowerCase().matches(searchExpression) == true) {
				findedList.add(searchList.get(i));
			}
		}
		windowPanel.contentPanel.setNewLeftPanelList(findedList);
	}
}
