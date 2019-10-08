import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 프린터큐 {

	static class Document{
		int idx;
		int priority;
		public Document(int idx,int priority) {
			// TODO Auto-generated constructor stub
			this.idx=idx;
			this.priority=priority;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			Queue<Document> queue=new LinkedList<>();
			int[] pArr=new int[10];
			
			
			for (int i = 0; i < N; i++) {
				int priority=sc.nextInt();
				pArr[priority]++;
				queue.add(new Document(i, priority));
			}
			int count=0;
			int idx=9;
			while(true) {
				if(pArr[idx]==0) {
					idx--;
					if(idx==0) break;
				}else {
					Document d=queue.poll();
					if(d.priority==idx) {
						count++;
						pArr[idx]--;
						if(d.idx==M) {break;}
					}else {
						queue.add(d);
					}
				}
			}
			System.out.println(count);
			
		}//tc
	}


}
