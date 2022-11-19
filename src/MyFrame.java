import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame {

	public MyFrame(String title) {
		this();
		this.setTitle(title);

	}

	public MyFrame() { //creates the frame in the right layout and size

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 730));
		setLayout(new BorderLayout());
		setResizable(false);
	}

}
