package finalterm;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;


public class CopyText {
	public static void main(String[] args) throws Exception {
			// Check command line parameter usage 
//		if (args.length != 2) {
//			System.out.println("Usage: java CopyText sourceFile targetFile");
//			System.exit(0); 
//		}
		
		String path = CopyText.class.getResource("").getPath();
		// Create input and output files
		
		System.out.println(path);
		
		File sourceFile = new File("test.txt");
		File targetFile = new File("output.txt");
		
		Scanner input = new Scanner(sourceFile); 
		PrintWriter output = new PrintWriter(targetFile);
		while (input.hasNext()) {
			String s1 = input.nextLine(); 
			output.write(s1 + "\n");
		}
		input.close();
		output.close(); 
	}
}
