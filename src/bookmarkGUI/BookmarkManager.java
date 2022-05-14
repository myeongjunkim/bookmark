package bookmarkGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class BookmarkManager extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkManager() {
		
		DefaultTableModel model = new DefaultTableModel();
		String headers[] = {"","Group", "Name", "URL", "Created Time", "Memo"};
		model.setColumnCount(headers.length); 
		model.setColumnIdentifiers(headers);
		
		JTable table = new JTable(model);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(650, 300));
		
		

//		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		
//		셋트, 변경 후 변경사항 저
//		model.setValueAt("value", 0, 0); 
//		model.fireTableDataChanged();
		
		
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
