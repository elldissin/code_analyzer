package code_analyzer.gui;
import javax.swing.JFrame;

public class WindowFrame extends JFrame {
	WindowFrame() {
		WindowPanel windowPanel = new WindowPanel();
		this.add(windowPanel);
		this.setFocusable(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
