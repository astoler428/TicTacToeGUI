import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FahrenheitPanel extends JPanel implements ActionListener {
	
	JTextField textField;
	JLabel label1, label2, label3;
	int celsius;
	
	public FahrenheitPanel() {
		textField = new JTextField(5);
		textField.addActionListener(this);
		label1 = new JLabel("Enter Fahrenheit Temperature: ");
		label2 = new JLabel("Temperature in Celsius: ");
		label3 = new JLabel();
		
		this.add(label1);
		this.add(textField);
		this.add(label2);
		this.add(label3);
		
		setPreferredSize(new Dimension(300, 75));
		setBackground(Color.yellow);
	}
	

	public void actionPerformed(ActionEvent e) {
		int fahr = Integer.parseInt(textField.getText());
		celsius = 5*(fahr - 32)/9;
		label3.setText(Integer.toString(celsius));
		
	}
	

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.add(new FahrenheitPanel());
		frame.pack();
		frame.setVisible(true);
	}


	

}
