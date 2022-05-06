package arrayList;

public class ObjectArrayListLimitedCapacity {
	
	protected Object[] array;
	protected int size=0;
	protected static final int DEFAULT_CAPACITY = 16;
	
// 생성자
	public ObjectArrayListLimitedCapacity() {
	    this(DEFAULT_CAPACITY);
	}
	
	public ObjectArrayListLimitedCapacity(int capacity) {
	    this.array = new Object[capacity];
	}
	
	
// 매소드
	public void add(Object o) {
		this.array[this.size++] = o;
	}
	
	public void add(int index, Object o) {
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
