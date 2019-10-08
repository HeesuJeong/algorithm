import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

//1218
public class 괄호짝짓기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack<Character> st=new Stack<>();
		Map<Character, Character> mm=new HashMap<Character,Character>();
		mm.put('(', ')');
		mm.put('[', ']');
		mm.put('{', '}');
		mm.put('<', '>');
		for (int tc = 1; tc <=10; tc++) {
			int len=sc.nextInt();
			String str=sc.next();
			boolean chk=true;
			for (int i = 0; i < str.length(); i++) {
				char now=str.charAt(i);
				int topIdx=0;
				int nowIdx=0;
				if(now=='('||now=='['||now=='{'||now=='<') {
					st.push(now);
				}
				else {
					char topChar=st.peek();
					if(mm.get(topChar)==now) {
						st.pop();
					}else {
						chk=false;
						break;
					}
				}
			}
			System.out.print("#"+tc+" ");
			if(chk) {
				System.out.println("1");
			}
			else {System.out.println("0");}
		}//tc
	}

}
