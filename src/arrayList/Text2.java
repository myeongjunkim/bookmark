package arrayList;

public class Text2 {

	public static void main(String[] args) {
		
		System.out.println("\n[ObjectArrayList Test]\n");

		ObjectArrayList arrList2 = new ObjectArrayList();
		
		System.out.println("<Type Test>");
		arrList2.add(0,"타입 테스트를 위해 스트링 add");
		arrList2.add(1, 11111111);

		System.out.println("\n<check arrList>");
		for(int i=0; i<arrList2.size; i++) {
			System.out.println("[index "+i+"]: "+arrList2.get(i));
		}
		
		System.out.println("\n<기본용량인 16 크기로 생성된 arrList2에 용량을 초과하여 add>");
		System.out.println("(용량을 초과하는 경우, array를 2배로 증가)\n");
		for(int i=0; i<20; i++) {
			arrList2.add(i);
		}
		
		System.out.println("<check arrList>");
		for(int i=0; i<arrList2.size; i++) {
			System.out.println("[index "+i+"]: "+arrList2.get(i));
		}
		
	}

}
