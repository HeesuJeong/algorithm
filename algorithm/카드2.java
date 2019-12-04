import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {
	
	public static void main(String[] args) {
		Queue<Integer> q=new LinkedList<>();
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		while(q.size()>1) {
			q.poll();
			if(q.size()==1) break;
			int tmp=q.poll();
			q.add(tmp);
		}
		System.out.println(q.peek());
	}
}
