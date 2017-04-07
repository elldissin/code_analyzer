package code_analyzer.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBoxActionListener implements ActionListener {
	MenuPanel menuPanel;

	SearchBoxActionListener(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if (menuPanel.searchBox.getSelectedIndex() == 0)
			menuPanel.searchField.setText("Type the name of table here");
		if (menuPanel.searchBox.getSelectedIndex() == 1)
			menuPanel.searchField.setText("Type the name of field here");

	}

}
