import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class FlowLayoutTest extends JFrame implements KeyListener {
	
	ImageIcon imageIcon = new ImageIcon("res/1Club.png");
	ImageIcon imageIcon2 = new ImageIcon("res/1Diamond copy.png");
	ImageIcon imageIcon3 = new ImageIcon("res/ari.png");

	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JLabel l4 = new JLabel();
	
	
	
	Image image = imageIcon.getImage().getScaledInstance(90, 120,  java.awt.Image.SCALE_SMOOTH);
	Image image2 = imageIcon2.getImage().getScaledInstance(90, 120,  java.awt.Image.SCALE_SMOOTH);
	Image image3 = imageIcon3.getImage().getScaledInstance(90, 120,  java.awt.Image.SCALE_SMOOTH);
	

	public FlowLayoutTest(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLayout(new BorderLayout());
//		this.setResizable(false);


		JPanel handPanel = new JPanel();
		handPanel.setLayout(new FlowLayout());
		handPanel.setPreferredSize(new Dimension(100, 150));
		
		l1.setIcon(new ImageIcon(image));
		l1.setText("Club");
		l1.setHorizontalTextPosition(JLabel.CENTER);
		l1.setVerticalTextPosition(JLabel.CENTER);
		
		l2.setIcon(new ImageIcon(image));
		l3.setIcon(new ImageIcon(image2));
		l4.setIcon(new ImageIcon(image3));
		handPanel.add(l1);
		handPanel.add(l2);
		handPanel.add(l3);
		handPanel.add(l4);
		
		JPanel space = new JPanel();
		space.setBackground(Color.blue);
		space.setPreferredSize(new Dimension(300, 300));
		this.add(space, BorderLayout.CENTER);
		this.add(handPanel, BorderLayout.NORTH);
		
		this.setVisible(true);
		this.addKeyListener(this);
		}
	

	public static void main(String[] args) {

		new FlowLayoutTest();
		
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		l2.setIcon(new ImageIcon(image));
		l3.setIcon(new ImageIcon(image2));
		l4.setIcon(new ImageIcon(image3));
		
//		super.paintComponents(g);
//		g.setColor(Color.red);
//		g.drawString("5", 300, 255);
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == 'a') {
			//l4.setIcon(new ImageIcon(image));
			image3 = image;
			repaint();
		}
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
