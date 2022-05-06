package arrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\nMy arrayList Test\n");
//		ObjectArrayListLimitedCapacity myArrayList = new ObjectArrayListLimitedCapacity();
//		
//		System.out.println(myArrayList.isEmpty());
//		
//		myArrayList.add(0, "myasdf");
//		myArrayList.add(1, "myasdf");
//		myArrayList.add(2, 1);
//		myArrayList.add(3,5);
//		
//		for(int i=0; i<myArrayList.size(); i++) {
//			System.out.println(myArrayList.get(i));
//		}
//		System.out.println(myArrayList.isEmpty());
		
		ObjectArrayList myArrayList2 = new ObjectArrayList();
		
		for(int i=0; i<100; i++) {
			myArrayList2.add(2);
		}
		
		System.out.println(myArrayList2.array.length);
		
		
	}

}
