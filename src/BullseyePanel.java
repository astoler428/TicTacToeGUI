import java.awt.*;
import javax.swing.*;

public class BullseyePanel extends JPanel {
	
	JLabel label = new JLabel("HELLO");

	public BullseyePanel() {
		this.setPreferredSize(new Dimension(300, 300));
		this.setBackground(Color.gray);
		this.add(label, BorderLayout.SOUTH);
	}

	public void paint(Graphics g) {
		
		int step = 25;
		
		for(int i = 0; i < 5; i++) {
			if(i % 2 == 0)
				g.setColor(Color.black);
			else
				g.setColor(Color.white);
			
			g.fillOval(i*step,i*step, 300-2*i*step, 300-2*i*step);
		}
		
		g.setColor(Color.red);
		g.fillOval(5*step,5*step, 300-2*5*step, 300-2*5*step);
		
		System.out.println("hi");


	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new BullseyePanel());
		frame.pack();
		frame.setVisible(true);
	}

}
