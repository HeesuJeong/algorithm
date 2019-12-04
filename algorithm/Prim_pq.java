package MST;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim_pq {

	static class Edge implements Comparable<Edge>{
		int dest;
		int cost;
		Edge(int d, int c){
			dest = d;
			cost = c;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner("7 11\n" + "0 1 31\r\n" + "0 2 31\r\n" + "0 6 31\r\n" + "0 5 60\r\n" + "1 2 21\r\n"
				+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n");
		
		//간선리스트를 만들자
		//각 정점별로 리스트를 하나씩 가지고 있어야한다
		//각 리스트에는 도착정점+경로비용의 정보가 있어야 한다
		int V = sc.nextInt();
		int E = sc.nextInt();
		ArrayList<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i <E; i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int cost=sc.nextInt();
			adj[v1].add(new Edge(v2,cost));
			adj[v2].add(new Edge(v1,cost));
		}
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		//선택된 정점을 표시하는 체크배열
		boolean[] visited=new boolean[V];
		int cnt=1; //선택된 정점의 수
		visited[0]=true;
		pq.addAll(adj[0]);
		int result=0;
		while(cnt<V) {
			//가장 작은 비용의 간선이 나온다
			Edge e=pq.poll();
			//이미 확보된 정점이 도착지면 패스
			if(visited[e.dest]) continue;
			//e.dest목적지 간선을 선택
			pq.addAll(adj[e.dest]);
			visited[e.dest]=true;
			cnt++;
			result+=e.cost;
		}
		System.out.println(result);
	}
}