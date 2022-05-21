import java.io.FileNotFoundException;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("\n<Bookmark info>\n");
		
		String path = Test.class.getResource("").getPath();
		
		BookmarkList firstList = new BookmarkList(path + "test.txt");
		
		
		
		
		
		
		System.out.println();
		for(int i=1; i<firstList.numBookmarks(); i++) {
			System.out.println(i+"번째 북마크");
//			firstList.getBookmark(i).print();
			System.out.println(firstList.getBookmark(i).group);

		}
		
		firstList.mergeByGroup();
		System.out.println();
		for(int i=1; i<firstList.numBookmarks(); i++) {
			System.out.println(i+"번째 북마크");
			System.out.println(firstList.getBookmark(i).group);
		}
		
	}

}
