package 수요일;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정 {
static int N;
static ArrayList<info> li=new ArrayList<>();

static Scanner sc= new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		N=sc.nextInt();
		for (int i = 0; i < N; i++) {
			int start=sc.nextInt();
			int end=sc.nextInt();
			li.add(new info(start,end));
		}
		
		Collections.sort(li, new Comparator<info>() {

			@Override
			public int compare(info o1, info o2) {
				// TODO Auto-generated method stub
				int c1=o1.end;
				int c2=o2.end;
				if(c1>c2) return 1;
				else if(c1<c2) return -1;
				else return (1)*(o1.start-o2.start);
			}
			
		});
		
//		for (int i = 0; i < li.size(); i++) {
//			System.out.printf("e:%d, s:%d, t:%d\n",li.get(i).end,li.get(i).start,li.get(i).time );
//		}
		int s=li.get(0).start;
		int e=li.get(0).end;
		int cnt=0;
		if(s!=e) cnt=1;
		
		for (int i = 0; i < li.size(); i++) {
			if(e<=li.get(i).start) {
				cnt++;
				//System.out.println("i는 "+i);
				s=li.get(i).start;
				e=li.get(i).end;
			}
		}
		System.out.println(cnt);
	}
	static class info{
		int time;
		int start;
		int end;
		public info(int start, int end) {
			// TODO Auto-generated constructor stub
			this.start=start;
			this.end=end;
			this.time=end-start;
		}
	}
}
