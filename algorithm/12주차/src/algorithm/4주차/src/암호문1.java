import java.util.LinkedList;
import java.util.Scanner;

public class 암호문1 {

	final static int T=10;
	static LinkedList<Integer> li;
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int tc = 1; tc <= T; tc++) {
			
			li=new LinkedList<>();
			int N=sc.nextInt();
			for (int i = 0; i < N; i++) {
				li.add(sc.nextInt());
			}
			
			int commandNum=sc.nextInt();
			for (int i = 0; i < commandNum; i++) {
				sc.next();
				int posi=sc.nextInt();
				int num=sc.nextInt();
				for (int j = 0; j < num; j++) {
					li.add(posi++,sc.nextInt());
				}
			}
			System.out.print("#"+tc+" ");
			for (int i = 0; i < 10; i++) {
				System.out.print(li.get(i)+" ");
			}
			System.out.println();
		}
	}

}
