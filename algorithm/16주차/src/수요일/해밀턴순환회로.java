package 수요일;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class 해밀턴순환회로 {

	static class info implements Comparable<info> {
		int dist;
		int cost;

		public info(int dist, int cost) {
			// TODO Auto-generated constructor stub
			this.dist = dist;
			this.cost = cost;
		}

		@Override
		public int compareTo(info o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	static ArrayList<info>[] map;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			map[i] = new ArrayList<>();
			for (int j = 1; j < N + 1; j++) {
				int input = sc.nextInt();
				if (input != 0) {
					map[i].add(new info(j, input));
				}
			}
		} //
		for (int i = 1; i <= N; i++) {
			Collections.sort(map[i]);
		}
		visited = new boolean[N + 1];
		result=Integer.MAX_VALUE;
		DFS(1, 0,0);
		System.out.println(result);
	}

	static int result;
	static boolean[] visited;

	private static void DFS(int start, int sum,int cnt) {
		// TODO Auto-generated method stub
		if(cnt>N) return;
		if(cnt>1&&cnt<N&&start==1) return;
		if (cnt == N && start == 1) {
			// 출발점 돌아왔을때 모든 장소 방문했어야해!
			result = Math.min(sum, result);
			return;
		}
		//System.out.println("start: "+start);
		for (int i = 0; i < map[start].size(); i++) {
			int dist = map[start].get(i).dist;
			int cost = map[start].get(i).cost;
			if(result<sum+cost) continue;
			if (visited[dist] == false) {
				// 시작점(1)은 시작할 때 true안 햇으므로 도착점으로 가능해
				// 다음 depth에서 기저로 적용되겠지
				visited[dist] = true;
				DFS(dist, sum+cost,cnt+1);
				visited[dist] = false;
			}
		}
	}

}
