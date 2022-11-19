import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class OuterTempPanel extends JPanel {
	
	
	TicTacToePanel panel1 = new TicTacToePanel();
	TicTacToePanel panel2 = new TicTacToePanel();
	

	public OuterTempPanel(){
	
		this.setSize(1200, 1200);
		//panel1.setBounds(0,0, 600, 600);
		this.setBackground(Color.red);
		this.setLayout(new GridLayout());

		this.add(panel1);
		//this.add(panel2);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		panel1.drawO(g2d,10,0);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 630));
		frame.add(new OuterTempPanel());
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
//		

	}

}
