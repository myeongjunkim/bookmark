package bookmarkGUI;

import java.awt.*;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookmarkListPanel extends JPanel{
		
	private static final long serialVersionUID = 1L;
	

	public BookmarkListPanel(BookmarkList bList) {
		DefaultTableModel model = new DefaultTableModel();
		String headers[] = {"","Group", "Name", "URL", "Created Time", "Memo"};
		
		model.setColumnCount(headers.length); 
		model.setColumnIdentifiers(headers);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String lastGroup = "";
		for(int i=0; i<bList.numBookmarks(); i++) {
			Bookmark b = bList.getBookmark(i);
			if(b.group =="") {
				model.addRow(new String[]{"", b.group, b.name, b.url, b.pubDate.format(formatter), b.memo});

			} else if(!b.group.equals(lastGroup)) {
				
//				System.out.println(b.group+" "+lastGroup);

				model.addRow(new String[]{">", b.group, "", "", "", ""});
			}
			lastGroup = b.group;
		}
		
//		model.addRow(new String[]{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"});

		
		
		
		
		
		
		
//		모델 다 만들면 table 만들
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
	

	
	
}
