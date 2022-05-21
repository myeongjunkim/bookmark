package bookmarkGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookmarkInfo extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public BookmarkInfo() {
		
		DefaultTableModel model = new DefaultTableModel();
		String headers[] = {"Group", "Name", "URL", "Memo"};
		
		model.setColumnCount(headers.length); 
		model.setColumnIdentifiers(headers);
		
		model.addRow(new String[] {"", "", "", ""});
		
		
//		모델 다 만들면 table 만들
		JTable table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 300));		
		
		
		
		JButton inputBtn = new JButton("INPUT");
		inputBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String newLine[] = new String[4];
				for(int i=0; i<headers.length; i++) {
					String value = (String)model.getValueAt(0, i);
					System.out.println(value);
					newLine[i] = value;
				}
				model.addRow(newLine);
			    setVisible(true);

			}
		});
		
		
		// 본 layout에 추가
		setLayout(new BorderLayout());
		add(inputBtn, BorderLayout.EAST);
		add(scrollPane, BorderLayout.CENTER);
		pack();
	}
	
}
