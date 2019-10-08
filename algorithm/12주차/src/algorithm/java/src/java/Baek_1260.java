package java;

import java.util.Scanner;

public class Baek_1260 {
	
	static int[][] arr;
	static boolean[] isUse;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int startNode = sc.nextInt();
		
		arr = new int[1001][1001];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y]=1;
			arr[y][x]=1;
		}
		dfs(startNode,N);
	}

	private static void dfs(int startNode, int N) {
		// TODO Auto-generated method stub
		System.out.println(startNode);
		isUse[startNode] = true;
		for (int i = 1; i <= N; i++) {
			if(isUse[i]==true || arr[startNode][i]==0) {
				continue;
			}
			dfs(i,N);
		}
	}
}