package code_analyzer.gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
	WindowPanel windowPanel;
	JLabel info3;

	StatusPanel(WindowPanel windowPanel) {
		this.windowPanel = windowPanel;
		this.setPreferredSize(new Dimension(600, 30));
		JLabel info1 = new JLabel();
		info1.setText("Status:");
		this.add(info1);

		JLabel info2 = new JLabel();
		info2.setText("Info:");
		this.add(info2);

		info3 = new JLabel();
		info3.setText("Path:");
		this.add(info3);
	}
}
