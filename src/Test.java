import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Bookmark info\n");
		
		BookmarkList firstList = new BookmarkList("test.txt");
		firstList.getBookmark(0).print();
	}

}
