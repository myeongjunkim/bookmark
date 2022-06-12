package bookmarkGUI;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class BookmarkManager extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkManager(String bookmarkFileName) throws FileNotFoundException {
		
		// 가장 큰 틀인 BookmarkManager 만들고 파일 불러와서 List 장전
		String path = BookmarkManager.class.getResource("").getPath();
		BookmarkList bList = new BookmarkList(path + bookmarkFileName);
		bList.mergeByGroup();
		
		
		// 데이터가 들어갈 모델 선언
		DefaultTableModel mainModel = new DefaultTableModel();
		JTable mainTable = new JTable(mainModel);

		
		// 포메터 설정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter saveFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm");

	
		
		class BookmarkListPanel extends JPanel{
			
			private static final long serialVersionUID = 1L;
			
			public BookmarkListPanel() {
				
				String headers[] = {"","Group", "Name", "URL", "Created Time", "Memo"};
				mainModel.setColumnCount(headers.length); 
				mainModel.setColumnIdentifiers(headers);
				for(int i=0; i<bList.numBookmarks(); i++) {
					Bookmark b = bList.getBookmark(i);
					mainModel.addRow(new String[]{"", b.group, b.name, b.url, b.pubDate.format(formatter), b.memo});
				}
				
				//모델 다 만들면 table 만들
				mainTable.getColumnModel().getColumn(0).setPreferredWidth(10);
				mainTable.getColumnModel().getColumn(1).setPreferredWidth(20);
				mainTable.getColumnModel().getColumn(2).setPreferredWidth(20);
				mainTable.getColumnModel().getColumn(3).setPreferredWidth(150);

				
				JScrollPane scrollPane = new JScrollPane(mainTable);
				scrollPane.setPreferredSize(new Dimension(600, 300));		
				
				// 본 panel에 추가
				add(scrollPane);
			}
			
			
		}
		
		BookmarkListPanel p2 = new BookmarkListPanel();
				
		JButton addBtn = new JButton("ADD");
		JButton upBtn = new JButton("UP");
		JButton downBtn =  new JButton("DOWN");
		JButton saveBtn = new JButton("SAVE");
		JButton deleteBtn = new JButton("DELETE");


		
		// add  구현
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
						token[1] = LocalDateTime.now().format(saveFormatter);
						


						// newLine을 bookmark class 로 찍어내서 bList에 append
						Bookmark newBookmark = new Bookmark(token);
						bList.pushBookmark(newBookmark);
						
						
						// gui 추가ㅣ			
						Bookmark b = bList.getBookmark(bList.numBookmarks()-1);
						mainModel.addRow(new String[]{"", b.group, b.name, b.url, b.pubDate.format(formatter), b.memo});
						
						
						
					    addBtn.setEnabled(true);
					    upBtn.setEnabled(true);
					    downBtn.setEnabled(true);
					    deleteBtn.setEnabled(true);
					    saveBtn.setEnabled(true);
					    
					    setVisible(false);

					}
				
				});
				
				
				
				setLayout(new BorderLayout());
				add(inputBtn, BorderLayout.EAST);
				add(scrollPane, BorderLayout.CENTER);
				pack();
			}
		}
		
		
		// bookmarkInfo 생성(add 하는 창 띄우기)
		addBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				BookmarkInfo frame = new BookmarkInfo();
				frame.setTitle("BookmarkInfo");
			    frame.setSize(500, 100);
			    frame.setLocationRelativeTo(null); // Center the frame
			    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    frame.setVisible(true);
			    
			    addBtn.setEnabled(false);
			    upBtn.setEnabled(false);
			    downBtn.setEnabled(false);
			    deleteBtn.setEnabled(false);
			    saveBtn.setEnabled(false);
		    }
		});
		
		
		// delete 기능구
		deleteBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// <구현 할기능 정리>
				// -  Table.getSelectedRow();로 뭔 놈인지 알아내기
				// bookmarkList 인 bList 에서 삭제		
				
				int deleteIndex = mainTable.getSelectedRow();
				// gui 수정
				if(deleteIndex >=0 && deleteIndex < mainTable.getRowCount()) {
					mainModel.removeRow(deleteIndex);
					// 그룹 방법으로 갈 경우 수정 필요!!
					bList.deleteBookmark(deleteIndex);
				} else {
					JOptionPane.showMessageDialog(null, "북마크를 선택해 주세요!");
				}
				
		    }
		});
		
		
		upBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// <구현 할기능 정리>
				// 클릭된 행잡아오기,bList 수정,gui 수정
				
				int upIndex = mainTable.getSelectedRow();
				// gui 수정
				if(upIndex >0 && upIndex < mainTable.getRowCount()) {
					
					
					Bookmark b = bList.getBookmark(upIndex);
					// 그룹 방법으로 갈 경우 수정 필요!!
					bList.deleteBookmark(b);
					bList.insertBookmark(upIndex-1, b);
					
					//GUI 수정
					mainModel.setNumRows(0);
					for(int i=0; i<bList.numBookmarks(); i++) {
						Bookmark renewBookmark = bList.getBookmark(i);
						mainModel.addRow(new String[]{"", renewBookmark.group, renewBookmark.name, renewBookmark.url, renewBookmark.pubDate.format(formatter), renewBookmark.memo});
					}
					
					
				} else if(upIndex == 0) {
					JOptionPane.showMessageDialog(null, "맨 위 북마크입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "북마크를 선택해 주세요!");
				}
				
		    }
		});
		
		
		downBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// <구현 할기능 정리>
				// 클릭된 행잡아오기,bList 수정,gui 수정
				
				int downIndex = mainTable.getSelectedRow();
				// gui 수정
				if(downIndex >=0 && downIndex < mainTable.getRowCount()-1) {
					
					Bookmark b = bList.getBookmark(downIndex);
					// 그룹 방법으로 갈 경우 수정 필요!!
					bList.deleteBookmark(b);
					bList.insertBookmark(downIndex+1, b);
					
					//GUI 수정
					mainModel.setNumRows(0);
					for(int i=0; i<bList.numBookmarks(); i++) {
						Bookmark renewBookmark = bList.getBookmark(i);
						mainModel.addRow(new String[]{"", renewBookmark.group, renewBookmark.name, renewBookmark.url, renewBookmark.pubDate.format(formatter), renewBookmark.memo});
					}
					
				} else if(downIndex == mainTable.getRowCount()-1) {
					JOptionPane.showMessageDialog(null, "맨 아래 북마크입니다.");
				} else {
					JOptionPane.showMessageDialog(null, "북마크를 선택해 주세요!");
				}
				
		    }
		});
		
		
    
				
		
		
		saveBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				bList.mergeByGroup();
				//Gui 수정
				mainModel.setNumRows(0);
				for(int i=0; i<bList.numBookmarks(); i++) {
					Bookmark renewBookmark = bList.getBookmark(i);
					mainModel.addRow(new String[]{"", renewBookmark.group, renewBookmark.name, renewBookmark.url, renewBookmark.pubDate.format(formatter), renewBookmark.memo});
				}
				
				// <구현 할기능 정리>
				// 클릭된 행잡아오기,bList 수정,gui 수정
				File file = new File(path+bookmarkFileName);         
				try {            
					FileWriter fos = new FileWriter(file);
					for(int i=0; i<bList.numBookmarks(); i++) {
						Bookmark b = bList.getBookmark(i);
						fos.write(b.name +","+ b.pubDate.format(saveFormatter) +","+ b.url +","+ b.group +","+ b.memo);
						if(i != bList.numBookmarks()-1) {
							fos.write("\n");
						}
					}
					fos.close();

					JOptionPane.showMessageDialog(null, bookmarkFileName+" 저장완료");
					
				} catch (IOException error) {
					error.printStackTrace();
				} catch (Exception error) {
					error.printStackTrace();
				}
				
				
				
			}
				
				
				
		    
		});		
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(5, 1));
		p1.add(addBtn);
		p1.add(deleteBtn);
		p1.add(upBtn);
		p1.add(downBtn);
		p1.add(saveBtn);

	
//		전체 jframe 조정
		setLayout(new BorderLayout());
		add(p1, BorderLayout.EAST);
		add(p2, BorderLayout.CENTER);
		pack();
		
	}

}
