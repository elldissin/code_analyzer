package code_analyzer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import code_analyzer.db_elements.DBStructure;

public class ContentPanel extends JPanel {
	JScrollPane leftPanel;
	JList leftPanelJList;
	JLabel fieldList;
	JScrollPane fieldListScroller;
	MyTree tree;
	JScrollPane treePanel;
	String leftPanelSrting[] = {};
	WindowPanel windowPanel;
	LeftPanelSelectionListener leftPanelSelectionListener;
	DBStructure dBStructure = new DBStructure();

	ContentPanel(WindowPanel windowPanel) {

		this.windowPanel = windowPanel;
		this.setLayout(new GridLayout(1, 3));
		this.setPreferredSize(new Dimension(600, 600));

		leftPanelJList = new JList(leftPanelSrting);
		leftPanelJList.setForeground(Color.GREEN);
		leftPanelJList.setBackground(Color.BLACK);
		leftPanel = new JScrollPane(leftPanelJList);
		leftPanelSelectionListener = new LeftPanelSelectionListener(this);
		leftPanelJList.addListSelectionListener(leftPanelSelectionListener);
		this.add(leftPanel);

		fieldList = new JLabel();
		fieldList.setText("Field list:");
		fieldList.setVerticalAlignment(SwingConstants.TOP);
		fieldList.setForeground(Color.GREEN);
		fieldList.setOpaque(true);
		fieldList.setBackground(Color.BLACK);
		JScrollPane fieldListScroller = new JScrollPane(fieldList);
		// FIXME scroll disappeared
		this.add(fieldListScroller);

		tree = new MyTree(windowPanel);
		treePanel = new JScrollPane(tree);
		this.add(treePanel);

	}

	void setNewLeftPanelList(List<String> tableList) {
		leftPanelSrting = new String[tableList.size()];
		for (int i = 0; i < tableList.size(); i++) {
			leftPanelSrting[i] = tableList.get(i);
		}

		this.removeAll();
		leftPanelJList = new JList(leftPanelSrting);
		leftPanel = new JScrollPane(leftPanelJList);
		fieldListScroller = new JScrollPane(fieldList);
		LeftPanelSelectionListener leftPanelSelectionListener = new LeftPanelSelectionListener(this);
		leftPanelJList.addListSelectionListener(leftPanelSelectionListener);
		leftPanelJList.setForeground(Color.GREEN);
		leftPanelJList.setBackground(Color.BLACK);
		this.add(leftPanel);
		this.add(fieldListScroller);
		this.add(treePanel);
		this.repaint();
		this.revalidate();
	}

}
