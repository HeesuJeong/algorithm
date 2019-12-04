import java.util.Scanner;
import java.util.Stack;

public class 덧곱셈후위변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//피연산자는 출력
		//+ 스택에 있는놈 다 꺼내어 출력 => +담기
		//* 탑이 덧셈이면 푸쉬 / 아니라면 팝하고 푸쉬
		//마지막에 스택에 남은 녀석들을 꺼내어 출력
		
		Stack<Character> st=new Stack<>();
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		for (int i = 0; i < str.length(); i++) {
			char tmp=str.charAt(i);
			if(tmp=='+') {
				while(!st.empty()) {
					System.out.print(st.peek());
					st.pop();
				}
				st.push(tmp);
			}else if(tmp=='*') {
				if(st.peek()=='+') {
					st.push(tmp);
				}else {
					System.out.print(st.peek());
					st.pop();
					st.push(tmp);
				}
			}
			else {
				System.out.print(tmp);
			}
		}
		while(!st.empty()) {
		System.out.print(st.peek());
		st.pop();
		}
	}

}
