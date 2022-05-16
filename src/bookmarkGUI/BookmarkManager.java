package bookmarkGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BookmarkManager extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkManager() {
		
		
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			BookmarkInfo frame;
			@Override
			public void actionPerformed(ActionEvent e) {
				if (frame == null) {
					frame = new BookmarkInfo();
					frame.setTitle("BookmarkInfo");
				    frame.setSize(500, 100);
				    frame.setLocationRelativeTo(null); // Center the frame
				    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				    frame.setVisible(true);
				}
				
			}
		});
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1));
		p1.add(addBtn);
		p1.add(new JButton("DELETE"));
		p1.add(new JButton("UP"));
		p1.add(new JButton("DOWN"));
		p1.add(new JButton("SAVE"));
		
		BookmarkListPanel p2 = new BookmarkListPanel();
		
//		전체 jframe 조정
		setLayout(new BorderLayout());
		add(p1, BorderLayout.EAST);
		add(p2, BorderLayout.CENTER);
		pack();
	}

}
