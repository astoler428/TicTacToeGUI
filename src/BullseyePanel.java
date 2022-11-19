import java.awt.*;
import javax.swing.*;

public class BullseyePanel extends JPanel {

	public BullseyePanel() {
		this.setPreferredSize(new Dimension(300, 300));
		this.setBackground(Color.gray);
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
		
		


	}

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.add(new BullseyePanel());
		frame.pack();
		frame.setVisible(true);
	}

}
