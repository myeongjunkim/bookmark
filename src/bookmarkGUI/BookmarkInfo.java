package bookmarkGUI;

import java.awt.*;
import javax.swing.*;

public class BookmarkInfo extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkInfo() {
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 4));
		p1.add(new JLabel("Group"));
		p1.add(new JLabel("Name"));
		p1.add(new JLabel("URL"));
		p1.add(new JLabel("Memo"));
		
		p1.add(new JTextField());
		p1.add(new JTextField());
		p1.add(new JTextField());
		p1.add(new JTextField());

		
		add(new JButton("INPUT"), BorderLayout.EAST);
		add(p1, BorderLayout.CENTER);
	}
	
}
