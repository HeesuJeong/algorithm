import java.util.Scanner;
import java.util.Stack;

public class 후위표기식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st=new Stack<>();
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int resul=0;
		
		for (int i = 0; i < str.length(); i++) {
			char tmp=str.charAt(i);
			if(tmp=='+'||tmp=='-'||tmp=='*'||tmp=='/') {
				int operation1 = st.peek();
				st.pop();
				int operation2=st.peek();
				st.pop();
				if(tmp=='+') {
					resul=operation1+operation2;
				}else if(tmp=='-') {
					resul=operation2-operation1;
				}else if(tmp=='*') {
					resul=operation1*operation2;
				}else if(tmp=='/') {
					resul=operation2/operation1;
				}
				st.push(resul);
			}else {
				st.push(tmp-'0');
			}
		}
		System.out.println(resul);
	}

}
