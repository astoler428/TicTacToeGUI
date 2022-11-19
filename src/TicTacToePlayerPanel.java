import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;


public class TicTacToePlayerPanel extends JPanel implements ActionListener {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private static final int SQUARE_SIZE = HEIGHT / 3;
	private List<JButton> listOfButtons = new ArrayList<>();
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private List<List<JButton>> winningCombos = new ArrayList<>();
	private List<JButton> winningButtons = new ArrayList<>();	//will eventually store winning list of buttons

	private boolean turn;
	private int lastButtonPressed;

	List<JButton> myButtons = new ArrayList<>(); //holds the buttons i've pressed
	List<Point> myMoves = new ArrayList<>();
	List<Point> oppMoves = new ArrayList<>();
	List<Point> xMoves;
	List<Point> oMoves; //these will point to the proper moves

	Point lastMove; //stores the upper right corner of button that was just pressed

	public TicTacToePlayerPanel(boolean turn) { // set turn
		this.turn = turn;

		if (turn) {
			xMoves = myMoves;
			oMoves = oppMoves;
		} else {
			oMoves = myMoves;
			xMoves = oppMoves;
		}

		lastMove = null;  

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
		
		listOfButtons.add(b1);
		listOfButtons.add(b2);
		listOfButtons.add(b3);
		listOfButtons.add(b4);
		listOfButtons.add(b5);
		listOfButtons.add(b6);
		listOfButtons.add(b7);
		listOfButtons.add(b8);
		listOfButtons.add(b9);
		
		
		winningCombos.add(Arrays.asList(b1,b2,b3));
		winningCombos.add(Arrays.asList(b4,b5,b6));
		winningCombos.add(Arrays.asList(b7,b8,b9));
		winningCombos.add(Arrays.asList(b1,b4,b7));
		winningCombos.add(Arrays.asList(b2,b5,b8));
		winningCombos.add(Arrays.asList(b3,b6,b9));
		winningCombos.add(Arrays.asList(b1,b5,b9));
		winningCombos.add(Arrays.asList(b3,b5,b7));
		
		for(JButton button : listOfButtons) {
			button.addActionListener(this);
			add(button);
		}
	}
	
	public List<JButton> win() {
		List<JButton> toReturn = null;
		for(List<JButton> list : winningCombos)
			if(myButtons.containsAll(list))
				toReturn = list;
		
		return toReturn;	
	}
	
	public void setWinningButtons(List<JButton> winningButtons) {
		this.winningButtons = winningButtons;
		repaint();
	}

	public int getNumMoves() {
		return myMoves.size();
	}

	public int getLastButtonPressed() {
		return lastButtonPressed;
	}

	public void turnOffButton(int lastButtonPressed) {
		listOfButtons.get(lastButtonPressed).setVisible(false);
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public Point getLastMove() {
		return lastMove;
	}

	public void setLastMove(Point lastMove) {
		this.lastMove = lastMove;
	}

	public void addOppMove(Point point) {
		oppMoves.add(point);
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);


		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));	//paints the board
		
		g2d.drawLine(WIDTH / 3, 0, WIDTH / 3, HEIGHT);
		g2d.drawLine(2 * WIDTH / 3, 0, 2 * WIDTH / 3, HEIGHT);
		g2d.drawLine(0, HEIGHT / 3, WIDTH, HEIGHT / 3);
		g2d.drawLine(0, 2 * HEIGHT / 3, WIDTH, 2 * HEIGHT / 3);
		
		drawMoves(g2d);
		drawWin(g2d);
	}

	public void drawMoves(Graphics2D g2d) {	
		for (Point p : xMoves)							//prints all moves so far
			drawX(g2d, (int) p.getX(), (int) p.getY());

		for (Point p : oMoves)
			drawO(g2d, (int) p.getX(), (int) p.getY());
	}

	public void drawX(Graphics2D g, int x, int y) {
		g.setColor(Color.blue);
		g.drawLine(x, y, x + SQUARE_SIZE, y + SQUARE_SIZE);
		g.drawLine(x + SQUARE_SIZE, y, x, y + SQUARE_SIZE);
	}

	public void drawO(Graphics2D g, int x, int y) {
		g.setColor(Color.red);
		g.drawOval(x, y, SQUARE_SIZE, SQUARE_SIZE);
	}
	
	public void drawWin(Graphics2D g) { // usually null but will try to draw it
		if (!winningButtons.isEmpty()) {	
			Point startLocation = winningButtons.get(0).getLocation();
			Point endLocation = winningButtons.get(2).getLocation();
			int startX = (int) startLocation.getX() + SQUARE_SIZE / 2; // takes you to center of square
			int startY = (int) startLocation.getY() + SQUARE_SIZE / 2;
			int endX = (int) endLocation.getX() + SQUARE_SIZE / 2;
			int endY = (int) endLocation.getY() + SQUARE_SIZE / 2;
	
			g.setColor(Color.green);
			g.drawLine(startX, startY, endX, endY);
		}
		else
			g.drawLine(0, 0, 0, 0);
	}

	public void reset() {	//after game, resets moves, resets button visibility
		myMoves.clear();
		oppMoves.clear();
		myButtons.clear();

		
		//winningButtons.clear();

		turn = false;
		
		for(JButton button : listOfButtons)
			button.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if(turn) {
			JButton buttonPressed = (JButton) e.getSource();
			buttonPressed.setVisible(false);			//make button invisible, helps see drawing too and prevents from being pressed
			
			lastButtonPressed = listOfButtons.indexOf(buttonPressed);	//find location of button pressed to make invisible in other board too

			Point point = buttonPressed.getLocation();
			
			myMoves.add(point);	
			myButtons.add(buttonPressed);

			turn = false;
			lastMove = point;			//this is so we can add the point to the other panel
		}
	}
}