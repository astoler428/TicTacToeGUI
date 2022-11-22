import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;

public class HanabiFrameExperiment extends JFrame {

	HanabiCardExperiment card = new HanabiCardExperiment(3, Color.red);
	
	public HanabiFrameExperiment() { //creates the frame in the right layout and size

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1200, 800));
		pack();
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		card.draw(g, 100, 100);
		
	}
	
	public static void main(String[] args) {
		new HanabiFrameExperiment();
	}
}

