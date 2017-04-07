package code_analyzer.gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	WindowPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		MenuPanel menuPanel = new MenuPanel();
		this.add(menuPanel);
		ContentPanel contentPanel = new ContentPanel();
		this.add(contentPanel);
		StatusPanel statusPanel = new StatusPanel();
		this.add(statusPanel);
	}

}
