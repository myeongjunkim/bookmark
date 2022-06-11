package bookmarkGUI;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class BookmarkManager extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkManager(String bookmarkFileName) throws FileNotFoundException {
		
		// 가장 큰 틀인 BookmarkManager 만들고 파일 불러와서 List 장전
		String path = BookmarkManager.class.getResource("").getPath();
		BookmarkList bList = new BookmarkList(path + bookmarkFileName);
		bList.mergeByGroup();
		
		
		// 데이터가 들어갈 모델 설
		
		
	
		
		class BookmarkListPanel extends JPanel{
			
			private static final long serialVersionUID = 1L;
			
			DefaultTableModel model = new DefaultTableModel();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			public BookmarkListPanel() {
				
				String headers[] = {"","Group", "Name", "URL", "Created Time", "Memo"};
				model.setColumnCount(headers.length); 
				model.setColumnIdentifiers(headers);
				for(int i=0; i<bList.numBookmarks(); i++) {
					Bookmark b = bList.getBookmark(i);
					model.addRow(new String[]{"", b.group, b.name, b.url, b.pubDate.format(formatter), b.memo});
				}
				
				//모델 다 만들면 table 만들
				JTable table = new JTable(model);
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				table.getColumnModel().getColumn(1).setPreferredWidth(20);
				table.getColumnModel().getColumn(2).setPreferredWidth(20);
				table.getColumnModel().getColumn(3).setPreferredWidth(150);

				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setPreferredSize(new Dimension(600, 300));		
				
				// 본 panel에 추가
				add(scrollPane);
			}
			
			// 북마크 재정비 후 렌더링
			public void BookmarkListPanelRenewal() {
				Bookmark b = bList.getBookmark(bList.numBookmarks()-1);
				model.addRow(new String[]{"", b.group, b.name, b.url, b.pubDate.format(formatter), b.memo});

			}
			
		}
		
		BookmarkListPanel p2 = new BookmarkListPanel();
		
		
		
		// add 기능 구현
		class BookmarkInfo extends JFrame {
			
			private static final long serialVersionUID = 1L;

			public BookmarkInfo() {
				DefaultTableModel model = new DefaultTableModel();
				String headers[] = {"Group", "Name", "URL", "Memo"};
				
				model.setColumnCount(headers.length); 
				model.setColumnIdentifiers(headers);
				
				model.addRow(new String[] {"", "", "", ""});
				
				
//				모델 다 만들면 table 만들기
				JTable table = new JTable(model);
				table.getColumnModel().getColumn(0).setPreferredWidth(10);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setPreferredSize(new Dimension(600, 300));		
				
				
				JButton inputBtn = new JButton("INPUT");
				inputBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String token[] = new String[5];
						token[3] = (String)model.getValueAt(0, 0);
						token[0] = (String)model.getValueAt(0, 1);
						token[2] = (String)model.getValueAt(0, 2);
						token[4] = (String)model.getValueAt(0, 3);
						
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");
						token[1] = LocalDateTime.now().format(formatter);
						
						// newLine을 bookmark class 로 찍어내서 bList에 append
						Bookmark newBookmark = new Bookmark(token);
						bList.pushBookmark(newBookmark);
						
						System.out.println(token[3] + token[0] + token[2] + token[4]);
						
						p2.BookmarkListPanelRenewal();
						
					    setVisible(false);

					}
				
				});
				
				setLayout(new BorderLayout());
				add(inputBtn, BorderLayout.EAST);
				add(scrollPane, BorderLayout.CENTER);
				pack();
			}
		}
		
		
		// bookmarkInfo 생성(add 하는 창)
		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// e.getSource() 활용해보기
				// 여기를inner class 로 처리해서 frame 내부 컨트롤?

				BookmarkInfo frame = new BookmarkInfo();
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
		p1.add(new JButton("DELETE"));
		p1.add(new JButton("UP"));
		p1.add(new JButton("DOWN"));
		p1.add(new JButton("SAVE"));
		
		
		
//		전체 jframe 조정
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.EAST);
		add(p2, BorderLayout.CENTER);
		pack();
	}

}
