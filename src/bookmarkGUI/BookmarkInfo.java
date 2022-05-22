package bookmarkGUI;

import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookmarkInfo extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkInfo(BookmarkList bList) {
		
		DefaultTableModel model = new DefaultTableModel();
		String headers[] = {"Group", "Name", "URL", "Memo"};
		
		model.setColumnCount(headers.length); 
		model.setColumnIdentifiers(headers);
		
		model.addRow(new String[] {"", "", "", ""});
		
		
//		모델 다 만들면 table 만들기
		JTable table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 300));		
		
		
		
		JButton inputBtn = new JButton("INPUT");
		inputBtn.addActionListener(new ActionListener() {
			@Override
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
				bList.mergeByGroup();
			
				
			    setVisible(false);

			}
		});
		
		
		// 본 layout에 추가
		setLayout(new BorderLayout());
		add(inputBtn, BorderLayout.EAST);
		add(scrollPane, BorderLayout.CENTER);
		pack();
	}
	
}
