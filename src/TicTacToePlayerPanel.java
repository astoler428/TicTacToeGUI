import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

//Board is represented by 9 buttons the user can click on

public class TicTacToePlayerPanel extends JPanel {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private static final int SQUARE_SIZE = HEIGHT / 3;

	private List<JButton> listOfButtons = new ArrayList<>();
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;

	//to check for win, store a list of possible lists of buttons that would win
	private List<List<JButton>> winningCombos = new ArrayList<>();
	//will eventually store winning list of buttons to display the line through
	private List<JButton> winningButtons = new ArrayList<>();	

	private boolean turn;
	private int lastButtonPressed;

	//holds the buttons i've pressed
	List<JButton> myButtons = new ArrayList<>(); 
	//holds the coordinates of the points for our moves
	List<Point> myMoves = new ArrayList<>();
	List<Point> oppMoves = new ArrayList<>();
	//these will point to the proper moves
	List<Point> xMoves;
	List<Point> oMoves; 

	//stores the upper right corner of button that was just pressed
	Point lastMove; 

	//constructor

	public TicTacToePlayerPanel(ActionListener l, boolean turn) { 
		this.turn = turn;

		if (turn) {
			xMoves = myMoves;
			oMoves = oppMoves;
		} else {
			oMoves = myMoves;
			xMoves = oppMoves;
		}

		lastMove = null;  

		//setup GUI panel size and layout

		this.setSize(WIDTH, HEIGHT);
		this.setLayout(new GridLayout(3, 3, 0, 0));

		//initialize buttons

		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b7 = new JButton();
		b8 = new JButton();
		b9 = new JButton();
		
		//add buttons to listOfButtons

		listOfButtons.add(b1);
		listOfButtons.add(b2);
		listOfButtons.add(b3);
		listOfButtons.add(b4);
		listOfButtons.add(b5);
		listOfButtons.add(b6);
		listOfButtons.add(b7);
		listOfButtons.add(b8);
		listOfButtons.add(b9);
		
		//create winning combos
		
		winningCombos.add(Arrays.asList(b1,b2,b3));
		winningCombos.add(Arrays.asList(b4,b5,b6));
		winningCombos.add(Arrays.asList(b7,b8,b9));
		winningCombos.add(Arrays.asList(b1,b4,b7));
		winningCombos.add(Arrays.asList(b2,b5,b8));
		winningCombos.add(Arrays.asList(b3,b6,b9));
		winningCombos.add(Arrays.asList(b1,b5,b9));
		winningCombos.add(Arrays.asList(b3,b5,b7));
		
		//add actionListener to each button and add buttons to panel

		for(JButton button : listOfButtons) {
			button.addActionListener(l);
			this.add(button);
		}
	}
	
	//checks if I have won by seeing my my list of buttons contains everything in any of the winning combos
	public List<JButton> win() {
		List<JButton> toReturn = null;
		for(List<JButton> list : winningCombos)
			if(myButtons.containsAll(list))
				toReturn = list;
		
		return toReturn;	
	}
	
	//getter for all 9 buttons
	public List<JButton> getListOfButtons() {
		return listOfButtons;
	}

	//setter for when 3 winning buttons have been found so the line can be pained through
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
	
	public void addMyMove(Point point) {
		myMoves.add(point);
	}
	
	public void addMyButton(JButton button) {
		myButtons.add(button);
	}


	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(new BasicStroke(5));	
		
		//painting the 4 tic tac toe lines

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

	//draws an x based on the starting point
	public void drawX(Graphics2D g, int x, int y) {
		g.setColor(Color.blue);
		g.drawLine(x, y, x + SQUARE_SIZE, y + SQUARE_SIZE);
		g.drawLine(x + SQUARE_SIZE, y, x, y + SQUARE_SIZE);
	}

	//draws an o based on the center
	public void drawO(Graphics2D g, int x, int y) {
		g.setColor(Color.red);
		g.drawOval(x, y, SQUARE_SIZE, SQUARE_SIZE);
	}
	
	//draws the line through the winning combo if it exists
	public void drawWin(Graphics2D g) { 
		// usually null but will try to draw it
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
}