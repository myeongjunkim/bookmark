package bookmarkGUI;
import javax.swing.*;

public class TestGUI {

	public static void main(String[] args) {
		BookmarkManager frame = new BookmarkManager();
	    frame.setTitle("BookmarkManager");
	    frame.setSize(700, 350);
	    frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
	}

}
