import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextArea {
	
	JFrame frame;
	JTextArea tArea;
	
	public TextArea() {
		
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		
		tArea = new JTextArea(10, 10);
		tArea.setText("this will be written");
		tArea.setText("a new line \n" + tArea.getText());
		tArea.setEditable(true);	
		tArea.setLineWrap(true);	//forces stuff onto next line
		tArea.setWrapStyleWord(true);	//breaks at nearest word, not character
		
		JScrollPane scroll = new JScrollPane(tArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		frame.add(scroll);	//add the scroll which contains the component and not the component
		frame.pack();
		
		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		new TextArea();
	}
	

}
