import java.util.Iterator;

import javax.swing.JOptionPane;

public class EvenOdd {

	public static void main(String[] args) {
		
		
	
			

		String input, result;
		int num, again;

		do {
			input = JOptionPane.showInputDialog("Enter an Integer: ");
			num = Integer.parseInt(input);
			result = "The number you entered is: " + ((num % 2 == 0) ? "even" : "odd");
			JOptionPane.showMessageDialog(null, result);
			again = JOptionPane.showConfirmDialog(null, "Do another?");

		} while (again == JOptionPane.YES_OPTION);
		 

	}
	

}
