import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LabelImage {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		
		ImageIcon image = new ImageIcon("res/ari.png");


		JLabel label1 = new JLabel();
		label1.setIcon(image);
		label1.setForeground(Color.green);
		label1.setFont(new Font("MVBoli", Font.PLAIN,20));
		label1.setText("This is Ari");
		//JLabel label1 = new JLabel("This is ari", image, SwingConstants.RIGHT); //this determines where the label goes
		label1.setHorizontalTextPosition(JLabel.CENTER); // this determines where the text is in relation to image
		label1.setVerticalTextPosition(JLabel.TOP); // this determines where the text is in relation to image
		label1.setBackground(Color.black);
		label1.setOpaque(true);
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.setBackground(Color.gray);
		panel.setPreferredSize(new Dimension(300, 350));
		

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}
