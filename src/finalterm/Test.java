package finalterm;

public class Test {
	public static void main(String[] args) {
		ParaGenStack<String> testStack = new ParaGenStack<String>();
		
		System.out.println(testStack.isEmpty());
		
		testStack.push("명준 명준");
		testStack.push("1");
		
		System.out.println(testStack.pop());
		
		System.out.println(testStack.isEmpty());
		
	}
}	
