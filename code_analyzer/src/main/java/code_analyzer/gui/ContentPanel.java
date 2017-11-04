package code_analyzer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import code_analyzer.db_elements.DBStructure;

public class ContentPanel extends JPanel {
	JScrollPane leftPanel;
	JList leftPanelJList;
	JScrollPane middlePanel;
	JList middlePanelJList;
	MyTree tree;
	JScrollPane rightPanel;
	String leftPanelString[] = {};
	String middlePanelString[] = {};
	WindowPanel windowPanel;
	LeftPanelSelectionListener leftPanelSelectionListener;
	DBStructure dBStructure = new DBStructure();

	ContentPanel(WindowPanel windowPanel) {

		this.windowPanel = windowPanel;
		this.setLayout(new GridLayout(1, 3));
		this.setPreferredSize(new Dimension(600, 600));

		leftPanelJList = new JList(leftPanelString);
		leftPanelJList.setForeground(Color.GREEN);
		leftPanelJList.setBackground(Color.BLACK);
		leftPanel = new JScrollPane(leftPanelJList);
		leftPanelSelectionListener = new LeftPanelSelectionListener(this);
		leftPanelJList.addListSelectionListener(leftPanelSelectionListener);
		this.add(leftPanel);

		middlePanelJList = new JList(middlePanelString);
		middlePanelJList.setForeground(Color.GREEN);
		middlePanelJList.setBackground(Color.BLACK);
		middlePanel = new JScrollPane(middlePanelJList);
		this.add(middlePanel);

		tree = new MyTree(windowPanel);
		rightPanel = new JScrollPane(tree);
		this.add(rightPanel);

	}

	void setNewLeftPanelList(List<String> tableList) {
		leftPanelString = new String[tableList.size()];
		for (int i = 0; i < tableList.size(); i++) {
			leftPanelString[i] = tableList.get(i);
		}

		this.removeAll();
		leftPanelJList = new JList(leftPanelString);
		leftPanel = new JScrollPane(leftPanelJList);
		LeftPanelSelectionListener leftPanelSelectionListener = new LeftPanelSelectionListener(this);
		leftPanelJList.addListSelectionListener(leftPanelSelectionListener);
		leftPanelJList.setForeground(Color.GREEN);
		leftPanelJList.setBackground(Color.BLACK);
		this.add(leftPanel);
		this.add(middlePanel);
		this.add(rightPanel);
		this.repaint();
		this.revalidate();
	}

}
