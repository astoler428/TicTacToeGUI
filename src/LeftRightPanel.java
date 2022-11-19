import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftRightPanel extends JPanel implements ActionListener {

	JButton left, right;
	JLabel label;
	JPanel buttonPanel;

	public LeftRightPanel() {
		
		this.setPreferredSize(new Dimension(200, 80));
		
		label = new JLabel("Push a button");

		left = new JButton("Left");
//		left.setFocusable(false);
//		left.setBackground(Color.red);
		right = new JButton("Right");
		
		left.addActionListener(this);
		right.addActionListener(this);

		buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.blue);
		buttonPanel.setPreferredSize(new Dimension(200, 40));
		buttonPanel.add(left);
		buttonPanel.add(right);
		
		this.add(label);
		this.add(buttonPanel);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == left)
			label.setText("left");
		else
			label.setText("right");
		
	}
	
	public static void main(String[] args) {
//		JFrame frame = new JFrame("Left Right");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(new LeftRightPanel());
//		frame.pack();
//		frame.setVisible(true);
		
		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		JButton b5 = new JButton();
		
		List<JButton> buttonList = new ArrayList<>();
		buttonList.add(b1);
		buttonList.add(b3);
		buttonList.add(b4);
		
		List<JButton> buttonList2 = new ArrayList<>();
		buttonList2.add(b1);
		buttonList2.add(b2);
				
		System.out.println(buttonList.containsAll(buttonList2)); 
		
		
		ArrayList<Integer> list = new ArrayList<>();
		for(Integer i : list)
			System.out.println(i);
	
	}

}
