import java.awt.*;
import javax.swing.*;

//custom JFrame that creates the frame in the right layout and size
//two constructors for an optional String title to be passed

public class MyFrame extends JFrame {

	public MyFrame(String title) {
		this();
		this.setTitle(title);

	}

	public MyFrame() { 

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(600, 730));
		setLayout(new BorderLayout());
		setResizable(false);
	}

}
