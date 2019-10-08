import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class 괄호검사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		Stack<Character> st=new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			char tmp=str.charAt(i);
			if(tmp=='('||tmp=='{') {
				st.push(tmp);
			}
			else if(tmp==')'||tmp=='}') {
				try {
				st.pop();
				}catch(EmptyStackException e) {
					System.out.println("오류입니다!****");
				}
			}
			
		}
		
		if(!st.empty()) System.out.println("오류입니다!!!!!");
		
	}

}
