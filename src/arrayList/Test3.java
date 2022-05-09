package arrayList;

public class Test3 {

	public static void main(String[] args) {
		
		System.out.println("\n[MyArrayList Test]\n");

		MyArrayList<String> arrList3 = new MyArrayList<String>();
		System.out.println("<add (String o)>");
		arrList3.add("스트링으로 추가");
		arrList3.add("1122");
//		// 타입 에러 구문
//		 arrList3.add(12345);
		
		System.out.println("\n<check arrList3>");
		for(int i=0; i<arrList3.size(); i++) {
			System.out.println("[index "+i+"]: "+arrList3.get(i));
			System.out.println("is string?: "+ (arrList3.get(i) instanceof String));
		}
		
		
		MyArrayList<Integer> arrList4 = new MyArrayList<Integer>();
		System.out.println("\n<add (Integer o)>");
		arrList4.add(444);
		arrList4.add(555);
////		 타입 에러 구문
//		 arrList4.add("12345");
		
		System.out.println("\n<check arrList4>");
		for(int i=0; i<arrList4.size(); i++) {
			System.out.println("[index "+i+"]: "+arrList4.get(i));
			System.out.println("is Integer?: "+ (arrList4.get(i) instanceof Integer));
		}
	}
}
