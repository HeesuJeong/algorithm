package 수요일;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 점심식사시간 {
	static int N;
	static int[][] map;
	static class person implements Comparable<person>{
		int x;
		int y;
		int sel;
		int dist[];
		public person(int x,int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
			dist=new int[2];
		}
		@Override
		public int compareTo(person o) {
			// TODO Auto-generated method stub
			return this.dist[this.sel]-o.dist[o.sel];
		}
	}
	static ArrayList<person> persons;
	static class stair{
		int x;
		int y;
		int height;
		public stair(int x,int y,int height) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
			this.height=height;
		}
	}
	static stair[] stairs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			map=new int[N][N];
			persons=new ArrayList<>();
			stairs=new stair[2];
			int idx=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int input=sc.nextInt();
					map[i][j]=input;
					if(input==1) {
						//사람 정보 저장
						persons.add(new person(i, j));
					}else if(input>=2) {
						//계단정보 저장
						stairs[idx++]=new stair(i,j, input);
					}
				}
			}
			//모든사람들의 두 계단을 내려가기 시작하는 시간을 계산해두기(계단 입구 도착 1분 후에 계단 내려가기 시작한다)
			for (int i = 0; i <persons.size(); i++) {
				for (int j = 0; j < stairs.length; j++) {
					persons.get(i).dist[j]=Math.abs(persons.get(i).x-stairs[j].x)+Math.abs(persons.get(i).y-stairs[j].y)+1;
				}
			}
			//사람들을 계단에 배정하고 timetable로 계산한다.
			result=Integer.MAX_VALUE;
			powerset(0);
			System.out.println("#"+tc+" "+result);
		}//tc
	
	}
	static int result;
	private static void powerset(int c) {
		// TODO Auto-generated method stub
		// 계단 내려가는 시간(계단 최대 3명 가능)
		if(c==persons.size()) {
			//사람 계단에 배정 완료되었으므로 timetable로 계산
			int[][] timetable=new int[2][200];
			//선택된 계단까지의 시간을 기준으로 정렬해야해
			//그런데 사람들의 순서가 바뀌면 안 되니깐(powerset) pq를 사용해서 옮겨둬
			PriorityQueue<person> pq=new PriorityQueue<>();
			for (int i = 0; i <persons.size(); i++) {
				pq.add(persons.get(i));
			}
			int max=0;
			while(!pq.isEmpty()) {
				person tmp=pq.poll();
				int from=tmp.dist[tmp.sel];
				int to=from+stairs[tmp.sel].height;
				for (int j = from; j <to; j++) {
					if(timetable[tmp.sel][j]==3) {
						to++;
						continue;
					}
					timetable[tmp.sel][j]++;
				}
				max=Math.max(max, to);
			}
			result=Math.min(result, max);
			return;
		}
		persons.get(c).sel=0; //계단 0으로 배정
		powerset(c+1);
		persons.get(c).sel=1;
		powerset(c+1);
	}

}
