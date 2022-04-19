package midterm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 5, 3, 9, 7};
		MyArray firstArray = new MyArray(arr1);
		
		System.out.println("ele 3 : " + ""+firstArray.get(2));
		
		int[] arr2 = {2,4};
		MyArray secondArray = new MyArray(arr2);
		
		System.out.println("object num : " + ""+MyArray.numOfArrayCreated());
		
		System.out.println("isEquals : " + ""+firstArray.equals(secondArray));
		

	}

}
