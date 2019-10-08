package 목요일;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class 최적경로 {
	static int T;
	static Scanner sc=new Scanner(System.in);
	static int N;
	static ArrayList<Point> li;
	static int MIN=10000;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T=sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			N=sc.nextInt();
			visited=new boolean[N+2];
			MIN=10000;
			li=new ArrayList<>();
			for (int i = 0; i < N+2; i++) {
				li.add(new Point(sc.nextInt(),sc.nextInt()));
			}
			recur(2,li.get(0).x,li.get(0).y,0);
			System.out.println("#"+tc+" "+MIN);
		}//tc
	}
	
	static void recur(int c,int x,int y,int sum) {
		if(c==li.size()) {
			//System.out.println("들어왔나?");
			sum+=Math.abs(x-li.get(1).x)+Math.abs(y-li.get(1).y);
			MIN=Math.min(MIN, sum);
			return;
		}
		for (int i = 2; i < li.size(); i++) {
			if(visited[i]==false) {
				int tmp=Math.abs(x-li.get(i).x)+Math.abs(y-li.get(i).y);
				visited[i]=true;
				recur(c+1,li.get(i).x,li.get(i).y,sum+tmp);
				visited[i]=false;
			}
		}
	}
}
