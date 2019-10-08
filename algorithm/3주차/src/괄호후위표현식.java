import java.util.Scanner;
import java.util.Stack;

public class 괄호후위표현식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> st = new Stack<>();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int resul = 0;
		StringBuilder sb=new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) {
			char tmp = str.charAt(i);
			if(Character.isDigit(tmp)) {
				sb.append(tmp);
			}else if(tmp=='(') {
				st.push(tmp);
			}else if(tmp=='+') {
				while(!st.empty()&&st.peek()!='(') {
					sb.append(st.pop());
				}
				st.push(tmp);
			}else if(tmp=='*') {
				while(!st.empty()&&st.peek()!='+'&&st.peek()!='(') {
					sb.append(st.pop());
				}
				st.push(tmp);
			}else if(tmp==')') {
				char top=st.pop();
				while(top!='('&& !st.empty()) {
					sb.append(top);
					top=st.pop();
				}
			}
			
		}
		while(!st.empty()) sb.append(st.pop());
		
		System.out.println(sb.toString());
	}
}
