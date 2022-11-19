import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutTest extends JFrame {
		
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	JButton b5 = new JButton();
	JButton b6 = new JButton();
	JButton b7 = new JButton();
	JButton b8 = new JButton();
	JButton b9 = new JButton();
	
	
	public GridLayoutTest(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLayout(new GridLayout(3, 3, 10, 10));
		this.setResizable(false);

		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);
		this.add(b6);
		this.add(b7);
		this.add(b8);
		this.add(b9);
		
		
		this.setVisible(true);

	}
	

	public static void main(String[] args) {

		new GridLayoutTest();
		
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponents(g);
		g.setColor(Color.blue);
		g.drawLine(500/3, 0, 500/3, 500);
		g.drawLine(1000/3, 0, 1000/3, 500);
		g.drawLine(0, 500/3+20, 500, 500/3+20);
		g.drawLine(0, 1000/3+20,500, 1000/3+20);
		
	}

}
