package bookmarkGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookmarkListPanel extends JPanel{
		
	private static final long serialVersionUID = 1L;
	

	public BookmarkListPanel() {
		DefaultTableModel model = new DefaultTableModel();
		String headers[] = {"","Group", "Name", "URL", "Created Time", "Memo"};
		
		model.setColumnCount(headers.length); 
		model.setColumnIdentifiers(headers);
		
		model.addRow(new String[]{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"});
		model.addRow(new String[]{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"});

		
		
		
		
		
		
		
//		모델 다 만들면 table 만들
		JTable table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 300));		
		
		// 본 panel에 추가
		add(scrollPane);
	}
	

	
	
}
