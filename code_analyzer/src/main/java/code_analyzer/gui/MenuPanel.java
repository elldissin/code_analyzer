package code_analyzer.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPanel extends JPanel {
	JComboBox searchBox;
	JTextField searchField;
	WindowPanel windowPanel;
	BrowseButtonListener browseButtonListener;
	JButton searchButton;

	MenuPanel(WindowPanel windowPanel) {
		this.windowPanel = windowPanel;
		this.setPreferredSize(new Dimension(600, 40));

		String[] variants = { "Table", "Field", "Window" };
		// FIXME should take variants from config file
		searchBox = new JComboBox(variants);
		SearchBoxActionListener searchBoxActionListener = new SearchBoxActionListener(windowPanel);
		searchBox.addActionListener(searchBoxActionListener);
		this.add(searchBox);

		searchField = new JTextField();
		searchField.addKeyListener(new SearchFieldListener(this));
		searchField.setPreferredSize(new Dimension(300, 27));
		this.add(searchField);

		searchButton = new JButton();
		searchButton.setText("Search");
		SearchButtonListener searchButtonListener = new SearchButtonListener(windowPanel);
		searchButton.addActionListener(searchButtonListener);
		this.add(searchButton);

	}

	public void createBrowseButtonListener() {
		BrowseButton browseButton = new BrowseButton();
		browseButtonListener = new BrowseButtonListener(this, windowPanel.getContentPanel());
		browseButton.addActionListener(browseButtonListener);
		this.add(browseButton);
	}
}
