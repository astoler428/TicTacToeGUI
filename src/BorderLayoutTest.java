import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.blue);
		panel1.setPreferredSize(new Dimension(100, 100));
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.green);
		panel2.setPreferredSize(new Dimension(100, 100));
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.red);
		panel3.setPreferredSize(new Dimension(100, 100));
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.yellow);
		panel4.setPreferredSize(new Dimension(100, 100));
		
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.black);
		panel5.setPreferredSize(new Dimension(100, 100));
		
		frame.setLayout(new BorderLayout(20, 30));
		
		

		frame.add(panel1, BorderLayout.WEST);
		frame.add(panel2, BorderLayout.EAST);
		frame.add(panel3, BorderLayout.NORTH);
		frame.add(panel4, BorderLayout.SOUTH);
		frame.add(panel5, BorderLayout.CENTER);
		//frame.pack();
		frame.setVisible(true);
	}

}
