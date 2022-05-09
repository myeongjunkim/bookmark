package arrayList;

public class MyArrayList<T> {
	
	private T[] array;
	private int size=0;
	private static final int DEFAULT_CAPACITY = 16;
	
	public MyArrayList() {
	    this(DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity) {
	    this.array = (T[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public void add(T o) {
		if (this.size >= this.array.length) {
		      Object[] temp = new Object[this.array.length * 2];
		      System.arraycopy(this.array, 0, temp, 0, this.array.length);
		      this.array = (T[]) temp;
		    }
		this.array[this.size++] = o;
	}
	
	public void add(int index, T o) {		
		
		if (index>this.size) {
			System.out.println("index is out of range");
			
		} else {
			for(int i=this.size-1; i>=index; i--) {
				this.array[i+1] = this.array[i];
			}
			this.array[index] = o;
			size++;
		}
		
	}
	
	public Object get(int index) {
		if (index>=this.size) {
			System.out.println("index is out of range");
			return null;
		} else {
			return this.array[index];
		}
		
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public Object remove(int index) {
		if (index>=this.size) {
			System.out.println("index is out of range");
			return null;
		} else {
			Object ret = this.array[index];
			this.size--;
			for(int i=index; i<this.size; i++) {
				this.array[i] = this.array[i+1];
			}
			this.array[this.size] = null;
			return ret;
		}
		
	}
	
	public int size() {
		return this.size;
	}

}
