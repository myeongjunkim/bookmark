package midterm;

public class MyArray {

	static private int objectNum = 0;
	private int[] array;
	
	public MyArray(int size) {
		this.array = new int[size];
		objectNum++;
	}
	
	public MyArray(int[] newArray) {
		this.array = newArray;
		objectNum++;
	}
	
	public static int numOfArrayCreated() {
		return objectNum;
	}
	
	public int[] get() {
		return this.array;
	}
	
	public int get(int i) {
		return this.array[i];
	}
	
	public boolean equals(MyArray newArray) {
		int arrayLen = this.array.length;
		if (arrayLen == newArray.array.length) {
			for(int i=0; i<arrayLen; i++) {
				if(this.array[i] != newArray.array[i]) return false;
			}
			return true;
		} else return false;
	}
	
	public int maxl(int from, int to) {
		int maxValue = this.array[0];
		int maxIndex = 0;
		for(int i=from+1; i<=to; i++) {
			if(this.array[i]>maxValue) {
				maxValue = this.array[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
	
	public int max(int from, int to) {
		return this.array[maxl(from, to)];
	}

	

}

