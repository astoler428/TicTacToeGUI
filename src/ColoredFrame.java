import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColoredFrame {

	public static void main(String[] args) {

		MyFrame frame = new MyFrame("Colors!");
		
		JLabel label = new JLabel();
		label.setText("Hi it's Ari");
		ImageIcon image = new ImageIcon("res/ari.png");
		label.setIcon(image);
		label.setVerticalTextPosition(JLabel.BOTTOM);
		label.setHorizontalTextPosition(JLabel.CENTER);
	
		
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0, 0, 250, 250);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(250, 0, 250, 250);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0, 250, 500, 250);
		
		frame.setLayout(null);
		
		greenPanel.add(label);

	
		frame.add(redPanel);
		frame.add(bluePanel);
		frame.add(greenPanel);
		
		
		
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
