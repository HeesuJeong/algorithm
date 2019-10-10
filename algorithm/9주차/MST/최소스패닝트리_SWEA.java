package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 최소스패닝트리_SWEA {

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
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int TC=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			StringTokenizer ve=new StringTokenizer(br.readLine());
			int V = Integer.parseInt(ve.nextToken());
			int E = Integer.parseInt(ve.nextToken());
			ArrayList<Edge>[] adj = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				adj[i]=new ArrayList<>();
			}
			for (int i = 0; i <E; i++) {
				ve=new StringTokenizer(br.readLine());
				int v1=Integer.parseInt(ve.nextToken());
				int v2=Integer.parseInt(ve.nextToken());
				int cost=Integer.parseInt(ve.nextToken());
				adj[v1].add(new Edge(v2,cost));
				adj[v2].add(new Edge(v1,cost));
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			//선택된 정점을 표시하는 체크배열
			boolean[] visited=new boolean[V+1];
			int cnt=1; //선택된 정점의 수
			visited[1]=true;
			pq.addAll(adj[1]);
			long result=0;
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
			System.out.println("#"+tc+" "+result);
		}//tc
	}

}
