package bookmarkGUI;
import java.io.FileNotFoundException;

import javax.swing.*;

public class TestGUI {

	public static void main(String[] args) throws FileNotFoundException {
		
		BookmarkManager frame = new BookmarkManager("test.txt");
	    frame.setTitle("BookmarkManager");
	    frame.setSize(700, 350);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
	}

}
