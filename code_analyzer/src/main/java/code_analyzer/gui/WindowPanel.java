package code_analyzer.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	MenuPanel menuPanel;
	ContentPanel contentPanel;
	StatusPanel statusPanel;

	WindowPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		menuPanel = new MenuPanel(this);
		this.add(menuPanel);
		contentPanel = new ContentPanel(this);
		this.add(contentPanel);
		statusPanel = new StatusPanel(this);
		this.add(statusPanel);
		menuPanel.createBrowseButtonListener();
	}

	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public ContentPanel getContentPanel() {
		return contentPanel;
	}

	public StatusPanel getStatusPanel() {
		return statusPanel;
	}

}
