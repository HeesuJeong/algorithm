package 수요일;

import java.util.Arrays;
import java.util.Scanner;

public class 게리맨더링2_DFS {

	static int N;
	static int[][] map;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int[][] divide;
	static int[][] info;
	static int result;
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N - 2; i++) {
			for (int j = 1; j < N - 1; j++) {
				divide=new int[N][N];
				visited=new boolean[N][N];
				startX=i;
				startY=j;
				DFS(i,j,0);
			}
		}
	}

	private static void DFS(int x, int y, int dir) {
		// TODO Auto-generated method stub
		if(dir==3&&x==startX&&y==startY) {
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(divide[i]));
			}
			System.out.println();
			return;
		}
		for (int i = 0; i <2; i++) {
			if(dir+i==4) return;
			int nx=x+dx[dir+i];
			int ny=y+dy[dir+i];
			if(inMap(nx,ny)&&visited[nx][ny]==false) {
				visited[nx][ny]=true;
				divide[nx][ny]=5;
				DFS(nx,ny,dir+i);
				visited[nx][ny]=false;
				divide[nx][ny]=0;
			}
		}
	}

	static int startX;
	static int startY;

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	
}
