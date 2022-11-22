import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoveAri extends JFrame implements KeyListener, MouseListener {
	
	ImageIcon image;
	JLabel imageLabel;
	boolean moveable;
	int x = 0;
	int y = 0;
	
	public MoveAri() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(new Dimension(500, 500));
		this.setResizable(false);
		this.addKeyListener(this);
		
		moveable = false;


		
		//image = new ImageIcon("res/ari.png");
		image = new ImageIcon("res/1Club.png");
		
		
		imageLabel = new JLabel();
		//imageLabel.setBounds(x, y, 200, 200);
		imageLabel.addMouseListener(this);

		imageLabel.setIcon(image);
		imageLabel.setBorder(BorderFactory.createLineBorder(Color.red));
		//imageLabel.setIcon(null);
		
		this.add(imageLabel);
		
		//this.getContentPane().setBackground(Color.black);
		
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		MoveAri ari = new MoveAri();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'a': imageLabel.setLocation(imageLabel.getX() - 20, imageLabel.getY());
			break;
		case 'w': imageLabel.setLocation(imageLabel.getX(), imageLabel.getY() - 20);
			break;
		case 'd': imageLabel.setLocation(imageLabel.getX() + 20, imageLabel.getY());
			break;
		case 's': imageLabel.setLocation(imageLabel.getX(), imageLabel.getY() + 20);
			break;	
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 37: imageLabel.setLocation(imageLabel.getX() - 20, imageLabel.getY());
			break;
		case 38: imageLabel.setLocation(imageLabel.getX(), imageLabel.getY() - 20);
			break;
		case 39: imageLabel.setLocation(imageLabel.getX() + 20, imageLabel.getY());
			break;
		case 40: imageLabel.setLocation(imageLabel.getX(), imageLabel.getY() + 20);
			break;	
		}
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		imageLabel.setLocation(x,y);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
