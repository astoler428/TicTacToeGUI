import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NestedPanels {
	
	

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("Nested Panels");
		
		JPanel panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(150, 100));
		panel1.setBackground(Color.green);
		JLabel label1 = new JLabel("One");
		panel1.add(label1);

	
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(150, 100));
		panel2.setBackground(Color.red);
		JLabel label2 = new JLabel("Two");
		panel2.add(label2);


		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.blue);
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);

		
	}

}
