import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	Image image = new ImageIcon("res/ari.png").getImage();
	JLabel imageLabel = new JLabel(new ImageIcon("res/CardBackground.jpeg"));

	 

	
	public DrawPanel() {
		add(imageLabel);
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, 100, 100, null);
	}
}
