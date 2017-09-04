package code_analyzer.gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import code_analyzer.db_elements.DBStructure;

public class MyTree extends JPanel {
	JTree tree;
	WindowPanel windowPanel;
	public DefaultMutableTreeNode lvl1node;

	public MyTree(WindowPanel windowPanel) {
		this.windowPanel = windowPanel;
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Data Base");
		lvl1node = new DefaultMutableTreeNode("Tables:");
		root.add(lvl1node);
		tree = new JTree(root);
		tree.setForeground(Color.GREEN);
		tree.setBackground(Color.BLACK);
		this.add(tree);
		this.setForeground(Color.GREEN);
		this.setBackground(Color.BLACK);
	}

	public void setDB(DBStructure dBStructure) {
		for (int i = 0; i < dBStructure.getTableList().size(); i++) {
			DefaultMutableTreeNode lvl2node = new DefaultMutableTreeNode(dBStructure.getTableList().get(i).getName());
			lvl1node.add(lvl2node);
			for (int j = 0; j < dBStructure.getTableList().get(i).getChildList().size(); j++) {
				DefaultMutableTreeNode lvl3node = new DefaultMutableTreeNode(
						dBStructure.getTableList().get(i).getChildList().get(i).getName());
				lvl2node.add(lvl3node);
			}
		}
	}
}