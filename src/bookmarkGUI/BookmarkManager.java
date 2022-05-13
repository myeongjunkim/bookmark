package bookmarkGUI;

import java.awt.*;
import javax.swing.*;


public class BookmarkManager extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkManager() {
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1));
		p1.add(new JButton("ADD"));
		p1.add(new JButton("DELETE"));
		p1.add(new JButton("UP"));
		p1.add(new JButton("DOWN"));
		p1.add(new JButton("SAVE"));
		
//		전체 jframe
		setLayout(new BorderLayout());
		add(p1, BorderLayout.EAST);
		add(new JButton("Food to be placed here"),
			      BorderLayout.CENTER);
	}

}
