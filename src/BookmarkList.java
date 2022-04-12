import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class BookmarkList {

	public String name;
	private Bookmark[] array;
	private int size=0;
	
	BookmarkList(String bookmarkFileName) throws FileNotFoundException{
		this.name = bookmarkFileName;
		array = new Bookmark[100];
		
		
		File file = new File(bookmarkFileName);
		Scanner input = new Scanner(file);
		
		while (input.hasNextLine()) {
			String line = input.nextLine().trim();
			
			// 행 넘기기
			if (line.equals("")) continue;
			
			// 주석 예외처리
			if ("//".equals(line.substring(0,2))) continue;
			
			// 생략 요소 처리 
			String[] tokens = line.split(",|;", -1);
			
			// 시간 형식 예외처리;
			try {
				LocalDateTime.parse(tokens[1].trim(), 
						DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm"));
			} catch (DateTimeParseException e) {
				System.out.println(size+1+"번째 북마크의 날짜가 형식에 맞지 않습니다! (2000-01-01_00:00로 임시수정)");
				tokens[1] = "2000-01-01_00:00";
			}
			
			// url miss 예외처리
			if(tokens[2].trim().equals("")) {
				System.out.println(size+1+"번째 북마크의 url이 생략되었습니다");
			}

			array[size++] = new Bookmark(tokens);
		
        }
		input.close();
		
	}
	
	public int numBookmarks() {
		return size;
	}
	
	public Bookmark getBookmark(int i) {
		return array[i-1];
	}
	
	public void mergeByGroup() {
		System.out.println("Bookmark merge");
		
		for(int i=0; i<this.numBookmarks(); i++) {
			Bookmark target = this.array[i];
			for(int j=i-1; j>0; j--) {
				if(target.group.equals(this.array[j].group)) {
					for(int k=i-1; k>j; k--) {
						this.array[k+1] = this.array[k];
					}
				this.array[j+1] = target;
				break;
				}
			}
			
		}
		
	}

}

