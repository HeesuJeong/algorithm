package 수요일;

import java.util.Scanner;

public class _119구급대 {

	static int M;
	static int N;

	static boolean inMap(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}
				//상하좌우	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int endX;
	static int endY;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[M][N];
		visited = new boolean[M][N];
		endX = sc.nextInt();
		endY = sc.nextInt();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited[0][0]=true;
		DFS(0, 0, 0,0);
		System.out.println(result);
	}

	static int result = Integer.MAX_VALUE;

	private static void DFS(int x, int y, int dir,int cnt) {
		// TODO Auto-generated method stub
		if (result < cnt)
			return;
		if (x == endX && y == endY) {
			for (int i = 0; i <M; i++) {
				for (int j = 0; j <N; j++) {
					System.out.print(visited[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("cnt는:"+cnt+"===========");
			result = Math.min(result, cnt-1);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(inMap(nx,ny)&&map[nx][ny]==1&&visited[nx][ny]==false) {
				if(i==dir) {
					visited[nx][ny]=true;
					DFS(nx,ny,i,cnt);
				}else {
					visited[nx][ny]=true;
					DFS(nx,ny,i,cnt+1);
				}
				visited[nx][ny]=false;
			}
		}
	}

}
