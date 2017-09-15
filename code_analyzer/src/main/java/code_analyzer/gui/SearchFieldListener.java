package code_analyzer.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchFieldListener implements KeyListener {
	MenuPanel menuPanel;

	public SearchFieldListener(MenuPanel menuPanel) {
		this.menuPanel = menuPanel;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			menuPanel.searchButton.doClick();
		}

	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();

	}

	public void keyTyped(KeyEvent e) {
	}

}
