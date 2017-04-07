package code_analyzer.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContentPanel extends JPanel {
	ContentPanel() {
		this.setLayout(new GridLayout(1, 1));
		this.setPreferredSize(new Dimension(600, 600));
		JTextField contentField = new JTextField();
		this.add(contentField);
		// contentField.setPreferredSize(new Dimension(100, 30));
	}

}
