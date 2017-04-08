package code_analyzer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class ContentPanel extends JPanel {
	JScrollPane tableListPanel;
	JList tableList;
	JLabel fieldList;

	ContentPanel() {
		this.setLayout(new GridLayout(1, 2));
		this.setPreferredSize(new Dimension(600, 600));

		String TableListSrting[] = { "Tanble1", "Tanble2", "Tanble3" };
		tableList = new JList(TableListSrting);
		tableListPanel = new JScrollPane(tableList);
		TableListSelectionListener tableListSelectionListener = new TableListSelectionListener(this);
		tableList.addListSelectionListener(tableListSelectionListener);
		this.add(tableListPanel);

		fieldList = new JLabel();
		fieldList.setVerticalAlignment(SwingConstants.TOP);
		fieldList.setForeground(Color.GREEN);
		this.setBackground(Color.BLACK);
		this.add(fieldList);

	}

}
