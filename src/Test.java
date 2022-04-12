import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Bookmark info\n");
		
		String path = Test.class.getResource("").getPath();
//	    System.out.println(path);
		
		BookmarkList firstList = new BookmarkList(path + "test.txt");
		firstList.getBookmark(3).print();
		
	    System.out.println(firstList.numBookmarks());
	}

}
