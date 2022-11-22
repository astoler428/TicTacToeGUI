import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BorderPanel extends JPanel {
	
	DrawPanel dp;
	JButton button = new JButton("I'm in the center");


	public BorderPanel() {
		setLayout(new BorderLayout());
		setSize(new Dimension(500, 500));
		setBackground(Color.blue);
		
		dp = new DrawPanel();
		
		add(dp, BorderLayout.SOUTH);
		//add(button,BorderLayout.CENTER);
	}
	
	public void paintComponent(Graphics g) {
		dp.draw(g);
	}
}