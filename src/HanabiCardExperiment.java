import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HanabiCardExperiment {
	
	int value;
	Color color;
	int orientation; //0 will be
	Image background;
	

	public HanabiCardExperiment(int value, Color color) {
		this.value = value;
		this.color = color;
		background = new ImageIcon("res/CardBackground.jpeg").getImage().getScaledInstance(55, 135, Image.SCALE_DEFAULT);
		

	}
	
	public void draw(Graphics g, int x, int y){
	
		//g.drawImage(background, x, y, null);
		g.setFont(new Font("Ariel", Font.BOLD+Font.ITALIC, 100));
		g.setColor(new Color(255,114,118));
		g.fillRect(x,  y, 130, 200);
		g.setColor(new Color(139,0,0));
		 Graphics2D g2 = (Graphics2D) g;
		   g2.setStroke(new BasicStroke(3));
		g2.drawRect(x,  y, 130, 200);
		
		String val = Integer.toString(value);
		int width = g.getFontMetrics().stringWidth(val);
		g.drawString(val, x+width/2-5, y+135);
	}

}
