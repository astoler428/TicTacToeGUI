import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	int count;
	JButton button;
	JLabel label;

	
	public MyPanel() {
		count = 0;
		button = new JButton("Push me!");
		button.addActionListener(new ButtonListener());
		button.setForeground(Color.blue);
		button.setFont(new Font("Comic Sans", Font.BOLD, 20));
		button.setIcon(new ImageIcon("res/ari.png"));	
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setIconTextGap(-20);
		
		label = new JLabel("Count " + count);
		
		//setPreferredSize(new Dimension(300, 400));
		setBackground(Color.cyan);
		
		this.add(button);
		this.add(label);
	
	}
	
	

	private class ButtonListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			count++;
			label.setText("Count " + count);
		}
		
	}
	
public void actionPerformed(ActionEvent e) {
	count++;
	label.setText("Count " + count);
	
}

	
	
	
	
	
public static void main(String[] args) {

		
		MyFrame frame = new MyFrame("Button Thingy!");
		
		frame.add(new MyPanel());
		frame.pack();


		frame.setVisible(true);
	}









}
