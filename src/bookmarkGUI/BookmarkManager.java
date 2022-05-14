package bookmarkGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class BookmarkManager extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkManager() {
		
		DefaultTableModel model = new DefaultTableModel();
		String headers[] = {"","Group", "Name", "URL", "Created Time", "Memo"};
		
//		String contents[][] = {
//				{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"},
//				{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"},
//				{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"},
//				{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"},
//		};
		model.setColumnCount(headers.length); 
		model.setColumnIdentifiers(headers);
		
		model.addRow(new String[]{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"});
		model.addRow(new String[]{">", "potal", "naver", "naver.com", "2022.02.02", "dasd"});

//		model.setValueAt("value", 3, 3); 
//		model.fireTableDataChanged();
		
		
		JTable table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(650, 300));
		
		


		
//		셋트, 변경 후 변경사항 저
		
		
		
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
		add(scrollPane, 
				BorderLayout.CENTER);
		//		add(new JButton("Food to be placed here"), 
//				BorderLayout.CENTER);
	}

}
