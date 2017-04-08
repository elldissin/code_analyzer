package code_analyzer.gui;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class BrowseButton extends JButton {
	BufferedImage image;

	BrowseButton() {
		this.setText(" ");
		try {
			image = ImageIO.read(new File("folder.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, 100, 30, null);
	}

}
