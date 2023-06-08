import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//each Frame contains a TicTacToePlayerPanel and a JPanel containing a JLabel saying who's turn it is

public class TicTacToeGame implements ActionListener{ 

	public static void main(String[] args) {
		new TicTacToeGame();
	}
	
	TicTacToePlayerPanel player1Panel, player2Panel;
	MyFrame frame1, frame2;
	JPanel panel1, panel2;
	JLabel label1, label2;
	Point point = null;

	//constructor: sets up the two frames

	public TicTacToeGame() {
		player1Panel = new TicTacToePlayerPanel(this, true);
		player2Panel = new TicTacToePlayerPanel(this, false);

		frame1 = new MyFrame("Player 1");
		frame2 = new MyFrame("Player 2");

		panel1 = new JPanel();
		panel2 = new JPanel();
		
		label1 = new JLabel("Your Turn");
		label2 = new JLabel("Opponents Turn");
		
		label1.setFont(new Font("Comic Sans", Font.BOLD, 25));
		label2.setFont(new Font("Comic Sans", Font.BOLD, 25));
		
		label1.setHorizontalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.CENTER);

		panel1.setLayout(new GridLayout(1,1));
		panel2.setLayout(new GridLayout(1,1));
		
		panel1.add(label1);
		panel2.add(label2);
		
		frame1.add(player1Panel);
		frame1.add(panel1,BorderLayout.SOUTH);
		frame2.add(player2Panel);
		frame2.add(panel2, BorderLayout.SOUTH);

		panel1.setPreferredSize(new Dimension(600, 100));
		panel2.setPreferredSize(new Dimension(600, 100));
		
		frame1.pack();
		frame2.pack();
		frame1.setVisible(true);
		frame2.setVisible(true);
	}
	
	public boolean gameOver() {				
		boolean toReturn = false;
		
		//list will contain the set of winning buttons
		List<JButton> list = null;
		
		if((list = player1Panel.win()) != null) {
			player1Panel.setWinningButtons(list);
			player2Panel.setWinningButtons(list);
			toReturn = true;
		}
			
		if((list = player2Panel.win()) != null) {
			player1Panel.setWinningButtons(list);
			player2Panel.setWinningButtons(list);
			toReturn = true;
		}
		
		if(tie())
			toReturn = true;
		
		return toReturn;
	}
	
	private boolean tie() {
		return player1Panel.getNumMoves() + player2Panel.getNumMoves() == 9;
	}
	
	//if user selects play again:
	
	private void resetGame() {
		frame1.remove(player1Panel);
		frame2.remove(player2Panel);
		
		player1Panel = new TicTacToePlayerPanel(this, true);
		player2Panel = new TicTacToePlayerPanel(this, false);
		
		frame1.add(player1Panel);
		frame2.add(player2Panel);
		
		SwingUtilities.updateComponentTreeUI(frame1);
		SwingUtilities.updateComponentTreeUI(frame2);
		
		label1.setText("Your Turn");
		label2.setText("Opponent's Turn");
	}

	//method called when move is made
	
	private void performTurn(JButton button, TicTacToePlayerPanel myTurn, TicTacToePlayerPanel oppTurn) {
	
		//find the index of button pressed to make invisible in other board too

		int idx = myTurn.getListOfButtons().indexOf(button);	
		
		//can't be clicked on again
		myTurn.turnOffButton(idx);
		oppTurn.turnOffButton(idx);
		
		//add moves and change turns
		myTurn.addMyMove(button.getLocation());
		oppTurn.addOppMove(button.getLocation());
		myTurn.addMyButton(button);
		myTurn.setTurn(false);
		oppTurn.setTurn(true);	
	}

	//event listener for button clicked

	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();

		//only respond to click if it's the players turn who clicked the button

		if(player1Panel.getListOfButtons().contains(e.getSource()) && player1Panel.isTurn()) {
			performTurn(buttonPressed, player1Panel, player2Panel);	
			label1.setText("Opponent's Turn");
			label2.setText("Your Turn");
		}
		
		if(player2Panel.getListOfButtons().contains(e.getSource()) && player2Panel.isTurn()) {
			performTurn(buttonPressed, player2Panel, player1Panel);
			label2.setText("Opponent's Turn");
			label1.setText("Your Turn");
		}
			
		//check game over - could be a tie

		if(gameOver()) {
			
			//message will be displayed in the popup dialog box

			String message = "";
			
			if(player1Panel.win() != null) //means player1 made the last move and won
				message = "Player 1 wins!";
			else if(player2Panel.win() != null)
				message = "Player 2 wins!";
			else	//means it was a draw
				message = "Draw.";
			
			int again = JOptionPane.showConfirmDialog(null, message + " Play Again?");
			if (again == JOptionPane.YES_OPTION) 
				resetGame();	
			else
				System.exit(0);
		}
	}

}
