package 다익스트라;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//시작점과 도착점이 정해져있으면 최단거리가 정해진다.
//유향그래프일 때 사용
public class 다익스트라 {
	static int V; //정점 개수
	static int E; //간선 개수
	static int[][] adj;
	static ArrayList<Integer> list;
	static boolean[] visited;
	static int[] dist=new int[V];
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner("6 11\r\n" + "0 1 3\r\n" + "0 2 5\r\n" + "1 2 2\r\n" + "1 3 6\r\n" + "2 1 1\r\n"
				+ "2 4 6\r\n" + "2 3 4\r\n" + "3 4 2\r\n" + "3 5 3\r\n" + "4 0 3\r\n" + "4 5 6");
		
		V=sc.nextInt();
		E=sc.nextInt();
		adj=new int[V][V]; //이차원배열=>인접행렬
		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()][sc.nextInt()]=sc.nextInt();
		}
		//최단거리 기록할 배열
		dist=new int[V];
		visited=new boolean[V];
		//0번 정점에서 각 정점으로 최단거리 얼마인지 구하쟈
		visited[0]=true;
		for (int i = 0; i < V; i++) {
			dist[i]=adj[0][i];
			if(adj[0][i]==0) dist[i]=999;
		}
		System.out.println(Arrays.toString(dist));
		
		dist[0]=0; //시작점은 0으로
		
		//V-1개의 정점을 선택해가며 최단거리를 갱신할거임
		for (int i = 0; i < V-1; i++) {
			//dist배열 중에서 가장 값이 작은 정점을 찾으시오.
			int minIdx=0;
			int min=Integer.MAX_VALUE;
			for (int j = 0; j <V; j++) {
				if(!visited[j]&&min>dist[j]) {
					minIdx=j;
					min=dist[j];
				}
			}
			//모든 정점에 대해서 min위치를 들러서 다른 정점으로 가는 거리가 기존에 알던 dist보다 작으면 갱신.
			for (int j = 0; j <V; j++) {
				//min에서 검사하는 정점으로 갈 수 있는지 여부 adj[min][j]!=0
				//검사하는 정점까지 알고 있던 거리 dist[j]
				//min을 거쳐서 검사하는 정점까지 가는 거리 dist[min]+adj[min][j]
				if(adj[minIdx][j]!=0&&dist[minIdx]+adj[minIdx][j]<dist[j]) {
					dist[j]=dist[minIdx]+adj[minIdx][j];
				}
			}
			visited[minIdx]=true;
			System.out.println(Arrays.toString(dist));
		}
		
	}
}
