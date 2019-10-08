import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class 마이쮸 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<people> q=new LinkedList<people>();
		int[] arr=new int[10];
		Arrays.fill(arr, 0);
		
		System.out.println("사탕 몇 개 둘까요?");
		Scanner sc=new Scanner(System.in);
		int EAT=sc.nextInt();
		
		int eatSum=0;
		int peopleMax=1;
		q.add(new people(1,1));
		while(true) {
			int p=q.peek().peopleNum;
			int c=q.peek().candyNum;
			arr[p]+=c;
			eatSum+=c;
			if(eatSum>=EAT) {
				System.out.println("범인은 "+p+"입니다.");
				System.out.println("범인이 "+c+"개 먹어요.");
				break;
			}
			q.poll();
			q.add(new people(p,c+1));
			peopleMax++;
			q.add(new people(peopleMax,1));
		}
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0) {
				System.out.println(i+"가 총 "+arr[i]+"개를 먹었습니다.");
			}
		}
	}
	static class people{
		private int peopleNum;
		private int candyNum;
		
		public people(int p,int c) {
			// TODO Auto-generated constructor stub
			this.peopleNum=p;
			this.candyNum=c;
		}
	}
	
}
