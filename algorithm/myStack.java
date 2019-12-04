import java.io.Serializable;

class MyStackEmptyException extends RuntimeException{
	
}
class MyStackOverflowException extends RuntimeException{
	
}
//제네릭 
public class myStack<T> implements Serializable{
	T[] stack;
	int top;
	int max;
	public myStack(int m) {
		System.out.println("배열 크기 "+m+"인 스택이 생성되었습니다.");
		stack=(T[])new Object[m];  //new T[] 이런식으로 안 돼. 객체가 만들어지는 것이기 때문에 타입 지정되어 있어야해. 
		//받고나서 형변환해.
		max=m;
		this.top = -1;
	}
	public void push(T a) {
		if(top<max-1) {
		stack[++top]=a;
		}else {
			throw new MyStackOverflowException();
		}
		
	}
	public void pop() {
		if(top>=0) {
			System.out.println(stack[top--]);
		}else {
			throw new MyStackEmptyException();
		}
	}
	
}
