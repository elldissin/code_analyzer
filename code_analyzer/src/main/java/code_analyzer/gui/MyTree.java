package code_analyzer.gui;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MyTree extends JPanel {
	JTree tree; // наше дерево

	public MyTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Data Base");
		DefaultMutableTreeNode lvl1node1 = new DefaultMutableTreeNode("Table1");
		DefaultMutableTreeNode lvl1node2 = new DefaultMutableTreeNode("Table2");
		DefaultMutableTreeNode lvl1node3 = new DefaultMutableTreeNode("Table3");
		root.add(lvl1node1);
		root.add(lvl1node2);
		root.add(lvl1node3);
		lvl1node2.add(new DefaultMutableTreeNode("Field1"));
		lvl1node2.add(new DefaultMutableTreeNode("Field2"));
		lvl1node2.add(new DefaultMutableTreeNode("Field3"));
		tree = new JTree(root);
		tree.setForeground(Color.GREEN);
		tree.setBackground(Color.BLACK);
		this.add(tree);
		this.setForeground(Color.GREEN);
		this.setBackground(Color.BLACK);
	}
}