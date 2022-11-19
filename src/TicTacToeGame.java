import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TicTacToeGame implements ActionListener{ 
	
	//try revising where i pass an action listener into constructor of TicTacToePlayerPanel, so here can manage all actions

	TicTacToePlayerPanel player1Panel, player2Panel;
	MyFrame frame1, frame2;
	JPanel panel1, panel2;
	JLabel label1, label2;
	JButton button1, button2;
	Point point = null;

	public TicTacToeGame() {
		player1Panel = new TicTacToePlayerPanel(true);
		player2Panel = new TicTacToePlayerPanel(false);

		frame1 = new MyFrame("Player 1");
		frame2 = new MyFrame("Player 2");

		panel1 = new JPanel();
		panel2 = new JPanel();
		
		label1 = new JLabel("Your Turn");
		label2 = new JLabel();

		button1 = new JButton("Make Move");
		button2 = new JButton("Make Move");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		panel1.setLayout(null);
		panel2.setLayout(null);

		panel1.add(button1);
		panel2.add(button2);
		
		panel1.add(label1);
		panel2.add(label2);
		
		button1.setBounds(250, 10, 100, 50);
		label1.setBounds(267, 60, 100, 40);
		
		button2.setBounds(250, 10, 100, 50);
		label2.setBounds(267, 60, 100, 40);

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
	
	public boolean gameOver() {				//edit this to check for actual winning!
		boolean toReturn = false;
		
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
		
		/*
		 * Have a list of lists containing winning sequences of points
		 * If myMoves contains any of the lists in winning lists, you win
		 */
	}
	
	private boolean tie() {
		return player1Panel.getNumMoves() + player2Panel.getNumMoves() == 9;
	}
	
	private void resetGame() {
		frame1.remove(player1Panel);
		frame2.remove(player2Panel);
		
		player1Panel = new TicTacToePlayerPanel(true);
		player2Panel = new TicTacToePlayerPanel(false);
		
		frame1.add(player1Panel);
		frame2.add(player2Panel);
		
		SwingUtilities.updateComponentTreeUI(frame1);
		SwingUtilities.updateComponentTreeUI(frame2);
		
		label1.setText("Your Turn");
		label2.setText("");
	}

	public void actionPerformed(ActionEvent e) {

		if ((point = player1Panel.getLastMove()) != null && e.getSource() == button1) {	//if no button was pressed this will be null
			player2Panel.addOppMove(point);
			player2Panel.setTurn(true);	//sets other players turn, this got turned off when button was pressed
			player2Panel.turnOffButton(player1Panel.getLastButtonPressed()); //turn off button in same spot
			player1Panel.setLastMove(null); //sets this move to null so now a new button needs to be pressed
			label2.setText("Your Turn");
			label1.setText("");
		}
		else if ((point = player2Panel.getLastMove()) != null && e.getSource() == button2) {
			player1Panel.addOppMove(point);
			player1Panel.setTurn(true);
			player1Panel.turnOffButton(player2Panel.getLastButtonPressed());
			player2Panel.setLastMove(null);
			label1.setText("Your Turn");
			label2.setText("");
		}
		
		if(gameOver()) {
			
			String message = "";
			
			if(e.getSource() == button1 && player1Panel.win() != null) //means player1 made the last move and won
				message = "Player 1 wins!";
			else if(e.getSource() == button2 && player2Panel.win() != null)
				message = "Player 2 wins!";
			else	//means it was a draw
				message = "Draw.";
			
			int again = JOptionPane.showConfirmDialog(null, message + " Play Again?");	//edit this to say who wins or tie!
			if (again == JOptionPane.YES_OPTION) {
//				player1Panel.reset();
//				player2Panel.reset();
//				
//				if(e.getSource() == button1)		//other player starts this time
//					player2Panel.setTurn(true);
//				else
//					player1Panel.setTurn(true);
				
				resetGame();
			}
	
				
			else
				System.exit(0);
		}
	}

	public static void main(String[] args) {
		new TicTacToeGame();

	}

}
