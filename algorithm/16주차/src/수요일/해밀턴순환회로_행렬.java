package 수요일;

import java.util.Scanner;

public class 해밀턴순환회로_행렬 {

	static int N;
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N+1][N+1];
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				map[i][j]=sc.nextInt();
			}
		} //1번부터 N번까지이다
		visited=new boolean[N+1];
		visited[1]=true;
		DFS(1,0,1);
		System.out.println(result);
	}
	static int result=Integer.MAX_VALUE;
	static boolean[] visited;
	private static void DFS(int start, int sum, int cnt) {
		// TODO Auto-generated method stub
		if(sum>result) return;
		if(cnt==N&&map[start][1]!=0) { //N개 모두 방문했다
			//마지막 선택된 얘가 1과 연결되어야 한다.
			result=Math.min(result, sum+map[start][1]);
			return;
		}

		for (int i = 1; i <=N; i++) {
			if(visited[i]==false&&map[start][i]!=0) {
				//if(sum+map[start][i]>result) return;
				visited[i]=true;
				DFS(i,sum+map[start][i],cnt+1);
				visited[i]=false;
			}
		}
	}

}
