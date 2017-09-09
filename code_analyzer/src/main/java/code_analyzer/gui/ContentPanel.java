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
	JScrollPane tableListPanel;
	JList tableJList;
	JLabel fieldList;
	JScrollPane fieldListScroller;
	MyTree tree;
	JScrollPane treePanel;
	String tableListSrting[] = { "Table list:" };
	WindowPanel windowPanel;
	TableListSelectionListener tableListSelectionListener;
	DBStructure dBStructure = new DBStructure();

	ContentPanel(WindowPanel windowPanel) {

		this.windowPanel = windowPanel;
		this.setLayout(new GridLayout(1, 3));
		this.setPreferredSize(new Dimension(600, 600));

		tableJList = new JList(tableListSrting);
		tableJList.setForeground(Color.GREEN);
		tableJList.setBackground(Color.BLACK);
		tableListPanel = new JScrollPane(tableJList);
		tableListSelectionListener = new TableListSelectionListener(this);
		tableJList.addListSelectionListener(tableListSelectionListener);
		this.add(tableListPanel);

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

	void setNewTableList(List<String> tableList) {
		tableListSrting = new String[tableList.size()];
		for (int i = 0; i < tableList.size(); i++) {
			tableListSrting[i] = tableList.get(i);
		}

		this.removeAll();
		tableJList = new JList(tableListSrting);
		tableListPanel = new JScrollPane(tableJList);
		fieldListScroller = new JScrollPane(fieldList);
		TableListSelectionListener tableListSelectionListener = new TableListSelectionListener(this);
		tableJList.addListSelectionListener(tableListSelectionListener);
		tableJList.setForeground(Color.GREEN);
		tableJList.setBackground(Color.BLACK);
		this.add(tableListPanel);
		this.add(fieldListScroller);
		this.add(treePanel);
		this.repaint();
		this.revalidate();
	}

}
