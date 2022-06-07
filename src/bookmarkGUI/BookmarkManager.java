package bookmarkGUI;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;


public class BookmarkManager extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkManager(String bookmarkFileName) throws FileNotFoundException {
		
		String path = BookmarkManager.class.getResource("").getPath();
		BookmarkList bList = new BookmarkList(path + bookmarkFileName);
		bList.mergeByGroup();
		
		// bookmarkInfo 생성
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// e.getSource() 활용해보기
				// 여기를inner class 로 처리해서 frame 내부 컨트롤?
				BookmarkInfo frame = new BookmarkInfo(bList);
				frame.setTitle("BookmarkInfo");
			    frame.setSize(500, 100);
			    frame.setLocationRelativeTo(null); // Center the frame
			    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    frame.setVisible(true);
				
			}
		});
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1));
		p1.add(addBtn);
		p1.add(new JButton("DEaLETE"));
		p1.add(new JButton("UP"));
		p1.add(new JButton("DOWN"));
		p1.add(new JButton("SAVE"));
		
		BookmarkListPanel p2 = new BookmarkListPanel(bList);
		
//		전체 jframe 조정
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.EAST);
		add(p2, BorderLayout.CENTER);
		pack();
	}

}
