import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToePanel extends JPanel implements ActionListener {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	int xX[];
	int yX[];
	int xO[];
	int yO[];
	int xMoves;
	int oMoves;
	boolean xTurn;

	public TicTacToePanel() {

		xX = new int[9];
		yX = new int[9];
		xO = new int[9];
		yO = new int[9];

		xMoves = 0;
		oMoves = 0;
		xTurn = true;

		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new GridLayout(3, 3, 0, 0));
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b7 = new JButton();
		b8 = new JButton();
		b9 = new JButton();

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
	
	}

	public void paintComponent(Graphics g) {
		
		System.out.println("painting");
		
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));
		g2d.drawLine(WIDTH / 3, 0, WIDTH / 3, HEIGHT);
		g2d.drawLine(2 * WIDTH / 3, 0, 2 * WIDTH / 3, HEIGHT);
		g2d.drawLine(0, HEIGHT / 3, WIDTH, HEIGHT / 3);
		g2d.drawLine(0, 2 * HEIGHT / 3, WIDTH, 2 * HEIGHT / 3);

		drawMoves(g2d);		
	}
	
	public void drawMoves(Graphics2D g2d) {
		
		for (int i = 0; i < xMoves; i++)
			drawX(g2d, xX[i], yX[i]);

		for (int i = 0; i < oMoves; i++)
			drawO(g2d, xO[i], yO[i]);
	}

	public void drawX(Graphics2D g, int x, int y) {
		g.drawLine(x, y, x + WIDTH / 3, y + WIDTH / 3);
		g.drawLine(x + WIDTH / 3, y, x, y + WIDTH / 3);
	}

	public void drawO(Graphics2D g, int x, int y) {
		g.drawOval(x, y, WIDTH / 3, HEIGHT / 3);
		
	}
	
	public void reset() {
		xX = new int[9];
		yX = new int[9];
		xO = new int[9];
		yO = new int[9];
		
		xMoves = 0;
		oMoves = 0;
		xTurn = true;
		
		b1.setEnabled(true);
		b2.setEnabled(true);
		b3.setEnabled(true);
		b4.setEnabled(true);
		b5.setEnabled(true);
		b6.setEnabled(true);
		b7.setEnabled(true);
		b8.setEnabled(true);
		b9.setEnabled(true);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 630));
		frame.add(new TicTacToePanel());
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		b.setEnabled(false);
		Point p = b.getLocation();
		if (xTurn) {
			xX[xMoves] = (int) p.getX();
			yX[xMoves] = (int) p.getY();
			xMoves++;
			xTurn = false;
		} else {
			xO[oMoves] = (int) p.getX();
			yO[oMoves] = (int) p.getY();
			oMoves++;
			xTurn = true;
		}
		
		if(oMoves + xMoves == 9) {
			int again = JOptionPane.showConfirmDialog(null, "Play Again?");
			if(again == JOptionPane.YES_OPTION)
				reset();
			else
				System.exit(0);
		}


	}
}
