package finalterm;
import java.util.ArrayList;


public class ParaGenStack<T> extends ParaAbsStack<T> {
	public ParaGenStack() {
		this.arrayList = new ArrayList<T>();
	}
	
	public void push(T o) {
		System.out.println(o + "-> push 실행 완료");
		this.arrayList.add(o);
	};
	
	public T pop() {
		System.out.println("-> pop 실행 완료");
		T ret = this.arrayList.get(this.arrayList.size()-1);
		this.arrayList.remove(ret);
		return ret;
	};
	
}
