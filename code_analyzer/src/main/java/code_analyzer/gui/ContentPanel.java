package code_analyzer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;

public class ContentPanel extends JPanel {
	JScrollPane tableListPanel;
	JList tableJList;
	JLabel fieldList;
	JTree tree;
	JScrollPane treePanel;
	String tableListSrting[] = { "Tanble1", "Tanble2", "Tanble3" };
	WindowPanel windowPanel;
	TableListSelectionListener tableListSelectionListener;

	ContentPanel(WindowPanel windowPanel) {
		this.windowPanel = windowPanel;
		this.setLayout(new GridLayout(1, 3));
		this.setPreferredSize(new Dimension(600, 600));

		tableJList = new JList(tableListSrting);
		tableJList.setForeground(Color.GREEN);
		tableJList.setBackground(Color.BLACK);
		tableListPanel = new JScrollPane(tableJList);
		tableListSelectionListener = new TableListSelectionListener(windowPanel);
		tableJList.addListSelectionListener(tableListSelectionListener);
		this.add(tableListPanel);

		fieldList = new JLabel();
		fieldList.setVerticalAlignment(SwingConstants.TOP);
		fieldList.setForeground(Color.GREEN);
		this.setBackground(Color.BLACK);
		this.add(fieldList);

		MyTree tree = new MyTree();
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
		TableListSelectionListener tableListSelectionListener = new TableListSelectionListener(windowPanel);
		tableJList.addListSelectionListener(tableListSelectionListener);
		tableJList.setForeground(Color.GREEN);
		tableJList.setBackground(Color.BLACK);
		this.add(tableListPanel);
		this.add(fieldList);
		this.add(treePanel);
		this.repaint();
		this.revalidate();
	}

}
