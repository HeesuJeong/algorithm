import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐3 {
	static int TC;
	static Scanner sc=new Scanner(System.in);
	static int N;
	static int M;
	static Queue<info> q=new LinkedList<info>();
	static LinkedList<Integer> li=new LinkedList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC=sc.nextInt();
		for (int i = 0; i < TC; i++) {
			li.clear();
			q.clear();
			
			
			N=sc.nextInt();
			M=sc.nextInt();
			
			for (int j = 0; j <N; j++) {
				int tmp=sc.nextInt();
				q.add(new info(j,tmp));
				li.add(tmp);
			}
			
			Collections.sort(li,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o2,o1);
				}
			});
			
			
			boolean chk=false;
			int cnt=0;
			while(true) {
				info tmp=q.poll();
				if(tmp.priority==li.get(0)) {
					cnt++;
					if(tmp.num==M) {
						System.out.println(cnt);
						break;
					}
					li.remove(0);
				}else if(tmp.priority<li.get(0)) {
					q.add(tmp);
				}
			}
			
		}//TC
	}

	static class info{
		int num;
		int priority;
		public info(int num,int priority) {
			// TODO Auto-generated constructor stub
			this.num=num;
			this.priority=priority;
		}
	}
}
