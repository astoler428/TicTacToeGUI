import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Frame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 730));
		
		BorderPanel bp = new BorderPanel();
	
	
		frame.add(bp);
		frame.pack();
		
		frame.setVisible(true);
	}
}
