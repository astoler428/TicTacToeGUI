import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StyleOptionsPanel extends JPanel implements ItemListener{
	
	JLabel label;
	JCheckBox bold, italic;
	
	public StyleOptionsPanel() {
	
		label = new JLabel("Say it with Style!");
		label.setFont(new Font("Ariel", Font.PLAIN, 30));
		
		bold = new JCheckBox("Bold");
		italic = new JCheckBox("Italic");
		
		bold.addItemListener(this);
		italic.addItemListener(this);
		
		this.add(label);
		this.add(bold);
		this.add(italic);
		//this.setSize(new Dimension(300, 100));

		this.setPreferredSize(new Dimension(300, 100));
		this.setBackground(Color.cyan);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		StyleOptionsPanel panel = new StyleOptionsPanel();
		
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

	

	@Override
	public void itemStateChanged(ItemEvent e) {
		int style = Font.PLAIN;
		
		if(bold.isSelected())
			style = Font.BOLD;
		
		if(italic.isSelected())
			style += Font.ITALIC;
		
		label.setFont(new Font("Ariel", style, 30));
		
	}

}
