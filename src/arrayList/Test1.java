package arrayList;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("\n[ObjectArrayListLimitedCapacity Test]\n");
		
		ObjectArrayListLimitedCapacity arrList1 = new ObjectArrayListLimitedCapacity();
		
		System.out.println("<before add>");
		System.out.println("size: " + arrList1.size());
		System.out.println("isEmpty: " + arrList1.isEmpty());

		
		System.out.println("\n<add(Object o)>");
		arrList1.add("String 0");
		arrList1.add("String 1");
		arrList1.add("String 2");
		arrList1.add(12);
		arrList1.add(34);
		arrList1.add(56);
		
		System.out.println("\n<after add>");
		System.out.println("size: " + arrList1.size());
		System.out.println("isEmpty: " + arrList1.isEmpty());
		
		System.out.println("\n<check arrList>");
		for(int i=0; i<arrList1.size(); i++) {
			System.out.println("[index "+i+"]: "+arrList1.get(i));
		}
		
		System.out.println("\n<add(int index, Object o)>");
		arrList1.add(1, "+++++");
		arrList1.add(4, 111111);
		
		System.out.println("\n<check arrList>");
		for(int i=0; i<arrList1.size(); i++) {
			System.out.println("[index "+i+"]: "+arrList1.get(i));
		}
		
		
		System.out.println("\n<remove(int index)>");
		arrList1.remove(4);
		arrList1.remove(1);
		
		System.out.println("\n<check arrList>");
		for(int i=0; i<arrList1.size(); i++) {
			System.out.println("[index "+i+"]: "+arrList1.get(i));
		}


		
		


	}

}
