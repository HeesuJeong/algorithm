package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 디저트카페 {

	static int N;
	static int[][] map;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static boolean[] used = new boolean[101];

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static int result;
	static int startX;
	static int startY;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = 0;
			for (int i = 0; i <= N - 3; i++) {
				for (int j = 1; j <= N - 2; j++) {
					Arrays.fill(used, false);
					startX = i;
					startY = j;
					DFS(i, j, 0, 0);
				}
			}
			if (result == 0)
				System.out.println("#" + tc + " " + "-1");
			else
				System.out.println("#" + tc + " " + result);
		} // tc
	}

	private static void DFS(int x, int y, int dir, int cnt) {
		// TODO Auto-generated method stub
		if (dir == 3 && (startX == x && startY == y)) {
			result = Math.max(result, cnt);
			return;
		}
		if(!inMap(x, y)) return;
		if(used[map[x][y]])return;
		if (dir == 4)
			return;
		
		used[map[x][y]] = true; //현 위치를 방문체크
		int tx = x + dx[dir];
		int ty = y + dy[dir];
		DFS(tx, ty, dir, cnt + 1);
		DFS(tx, ty, dir + 1, cnt + 1);
		used[map[x][y]] = false;

	}

}
