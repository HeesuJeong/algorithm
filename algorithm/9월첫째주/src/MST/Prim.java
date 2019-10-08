package MST;

import java.util.ArrayList;
import java.util.Scanner;

public class Prim {

	static class Edge{
		int dest;
		int cost;
		Edge(int d,int c){
			dest=d;
			cost=c;
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
		for (int i = 0; i < adj.length; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i <E; i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int cost=sc.nextInt();
			adj[v1].add(new Edge(v2,cost));
			adj[v2].add(new Edge(v1,cost));
		}
		//선택된 정점이 모여있는 곳
		ArrayList<Integer> selList=new ArrayList<>();
		//선택된 정점을 표시하는 체크배열
		boolean[] visited=new boolean[V];
		
		//아무거나 한 정점을 선택한다(선택배열에 담고 체크배열에 체크)
		//선택한 정점이 V개가 될 때까지
		//선택된 정점에서 출발하는 간선 중 도착지가 선택되지 앟은 간선 중 비용이 가장 작은 간선을 선택
		//선택된 간선으로부터 연결되는 정점을 선택(선택배열에 담고 체크배열에 체크)
		
		int result=0;
		//0번 정점부터 방문
		selList.add(0);
		visited[0]=true;
		//선택한 정점이 V개가 될때까지
		while(selList.size()<V) {
			int min=Integer.MAX_VALUE;
			int minV=-1;
			//선택되있는 정점을 하나씩 꺼내
			for (int v : selList) {
				//각 정점별로 간선리스트를 모두 검사
				for (int i = 0; i < adj[v].size(); i++) {
					//adj[v].get(i) 하면 간선이 튀어나온다
					Edge e=adj[v].get(i);
					if(!visited[e.dest]&&min>e.cost) {
						min=e.cost;
						minV=e.dest; //선택된 간선
					}
				}
			}
			System.out.println(minV);
			visited[minV]=true;
			selList.add(minV);
			result+=min;
		}
		System.out.println(result);
	}
}
