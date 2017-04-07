package code_analyzer.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPanel extends JPanel {
	MenuPanel() {
		this.setPreferredSize(new Dimension(600, 40));

		String[] variants = { "Table", "Field", "Window" };
		// FIXME should take variants from config file
		JComboBox searchBox = new JComboBox(variants);
		this.add(searchBox);

		JTextField searchField = new JTextField();
		searchField.setPreferredSize(new Dimension(300, 27));
		this.add(searchField);

		JButton searchButton = new JButton();
		searchButton.setText("Search");
		// SearchButtonListener searchButtonListener = new
		// SearchButtonListener(this);
		// SearchButtonListener.addActionListener(searchButtonListener);
		this.add(searchButton);

		JButton BrowseButton = new JButton();
		BrowseButton.setText("Browse");
		BrowseButtonListener browseButtonListener = new BrowseButtonListener(this);
		BrowseButton.addActionListener(browseButtonListener);
		this.add(BrowseButton);
	}
}
