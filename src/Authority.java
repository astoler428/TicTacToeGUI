import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Authority {

	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setTitle("Authority");
		frame.setResizable(false);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		 
		JLabel label1 = new JLabel("Question authority,");
		JLabel label2 = new JLabel("but raise your hand first.");

		panel.add(label1);
		panel.add(label2);
		frame.add(panel);
		panel.setLocation(200, 200);
		frame.setVisible(true);

		//frame.pack();
	}
}
