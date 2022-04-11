import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookmarkList {

	public String name;
	public Bookmark[] array;
	public Integer length;
	
	BookmarkList(String bookmarkFileName) throws FileNotFoundException{
		this.name = bookmarkFileName;
		this.array = new Bookmark[100];
		this.length = 0;
		
		File file = new File(bookmarkFileName);
		Scanner input = new Scanner(file);
		
		while (input.hasNextLine()) {
			String[] tokens = input.nextLine().split(",;");
			this.array[length] = new Bookmark(tokens);
			length++;
        }
		input.close();
		
	}
	
	public int numBookmarks() {
		return this.length;
	}
	
	public Bookmark getBookmark(int i) {
		return this.array[i];
	}
	
	public void mergeByGroup() {
		System.out.println("Bookmark merge");
	}

}
