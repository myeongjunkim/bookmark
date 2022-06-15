package finalterm;

import java.util.ArrayList;


public abstract class ParaAbsStack<T> implements ParaStackInterface<T> {
	ArrayList<T> arrayList =new ArrayList<T>();
	public boolean isEmpty() {
		System.out.println("abstract 실행 완료");
		return arrayList.isEmpty();
	}
	
}
