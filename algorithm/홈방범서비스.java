package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방범서비스 {

	static int N;
	static int M;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			result = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited = new boolean[N][N];
					BFS(i, j, 2*N);
				}
			}
			System.out.println("#" + tc + " " + result);
		} // tc
	}

	static int result;

	static class info {
		int x;
		int y;

		public info(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	private static void BFS(int x, int y, int maxK) {
		// TODO Auto-generated method stub
		// 손해보면 그만
		// k가 2*N넘어도 stop하게 하자
		Queue<info> q = new LinkedList<info>();
		q.add(new info(x, y));
		visited[x][y] = true;
		int homeCNT = map[x][y] == 1 ? 1 : 0; // 처음 위치에 집 있니?
		int k = 1; // 크기는 1부터 시작
		while (!q.isEmpty()) {
			if (homeCNT * M >= (k * k + (k - 1) * (k - 1))) {
				// System.out.println(x + " " + y + " 에서 k: " + k + " 일 때 homeCNT: " + homeCNT);
				result = Math.max(result, homeCNT);
			}
			if (k > maxK)
				break;// 다 본거야
			int sz = q.size();
			k++;
			for (int j = 0; j < sz; j++) {
				info tmp = q.poll();
				for (int i = 0; i < dx.length; i++) {
					int nx = tmp.x + dx[i];
					int ny = tmp.y + dy[i];
					if (!inMap(nx, ny))
						continue;
					if (visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.add(new info(nx, ny));
						if (map[nx][ny] == 1) {
							// 집인 경우
							homeCNT++;
						}
					}
				}
			}
		}
	}

}
