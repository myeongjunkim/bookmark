package bookmarkGUI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bookmark {

	public String name;
	public String url;	
	public LocalDateTime pubDate;
	public String group;
	public String memo;
	
	public Bookmark(String[] tokens){
		this.name = tokens[0].trim();
		this.pubDate = LocalDateTime.parse(tokens[1].trim(), 
				DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm"));
		this.url = tokens[2].trim();
		this.group = tokens[3].trim();
		this.memo = tokens[4].trim();
		
	}
	
	public Bookmark(String line){
		String[] tokens = line.split(",;");
		this.name = tokens[0].trim();
		this.pubDate = LocalDateTime.parse(tokens[1].trim(), 
				DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm"));
		this.url = tokens[2].trim();
		this.group = tokens[3].trim();
		this.memo = tokens[4].trim();
		
	}
	
	public void print() {
		System.out.println("name: "+this.name);
		System.out.println("url: "+this.url);
		System.out.println("pubDate: "+this.pubDate.
				format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm")));
		System.out.println("group: "+this.group);
		System.out.println("memo: "+this.memo);
		System.out.println();

	}
	
}
