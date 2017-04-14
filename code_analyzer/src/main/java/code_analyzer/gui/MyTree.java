package code_analyzer.gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

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
}