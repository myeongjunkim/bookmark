package arrayList;

public class ObjectArrayList extends ObjectArrayListLimitedCapacity{
	
	public ObjectArrayList() {
		this.array = new Object[DEFAULT_CAPACITY];
	}
	
	public void add(Object o) {
		if (this.size >= this.array.length) {
		      Object[] temp = new Object[this.array.length * 2];
		      System.arraycopy(this.array, 0, temp, 0, this.array.length);
		      this.array = temp;
		    }
		this.array[this.size++] = o;
	}
}
