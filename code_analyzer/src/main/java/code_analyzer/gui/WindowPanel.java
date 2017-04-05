package code_analyzer.gui;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	WindowPanel() {
		this.setPreferredSize(new Dimension(200, 200));
		JButton BrowseButton = new JButton();
		BrowseButton.setText("Browse");
		BrowseButtonListener browseButtonListener = new BrowseButtonListener(this);
		BrowseButton.addActionListener(browseButtonListener);
		BrowseButton.setPreferredSize(new Dimension(100, 30));
		this.add(BrowseButton);
	}
}
