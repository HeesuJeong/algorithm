package 월요일;

import java.util.ArrayList;
import java.util.Scanner;

public class 감시 {
//N*M
	// 총 K개 cctv 있다. 5가지 종류 존재
	// 0빈칸 1~5 cctv 종류 6벽
	// cctv는 벽 통과 못 해
	// 다른 cctv는 통과 가능하다
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static int N;
	static int M;
	static int[][] map;
	static int result;

	static class info {
		int x;
		int y;
		int kind;

		public info(int x, int y, int kind) {
			super();
			this.x = x;
			this.y = y;
			this.kind = kind;
		}

		@Override
		public String toString() {
			return "info [x=" + x + ", y=" + y + ", kind=" + kind + "]";
		}
	}

	static ArrayList<info> cameras;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		cameras = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int input = sc.nextInt();
				if (input >= 1 && input <= 5) {
					cameras.add(new info(i, j, input));
				}
				map[i][j] = input;
			}
		}
		result = Integer.MAX_VALUE;
		DFS(0);
		System.out.println(result);
	}

	private static void DFS(int idx) {
		// TODO Auto-generated method stub
	/*	for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==================");*/
		if (idx == cameras.size()) {
			int semiResult = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0)
						semiResult++;
					else
						continue;
				}
			}
			/*System.out.println("중간 결과값 " + semiResult);*/
			result = Math.min(result, semiResult);
			return;
		}
		int kind = cameras.get(idx).kind;
		switch (kind) {
		case 1:
			for (int i = 0; i < dx.length; i++) {
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, true);
				DFS(idx + 1);
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, false);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) {
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, true);
				change(cameras.get(idx).x, cameras.get(idx).y, i + 2, idx + 10, true);
				DFS(idx + 1);
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, false);
				change(cameras.get(idx).x, cameras.get(idx).y, i + 2, idx + 10, false);
			}
			break;
		case 3:
			for (int i = 0; i < dx.length; i++) {
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, true);
				change(cameras.get(idx).x, cameras.get(idx).y, i + 1 == 4 ? 0 : i + 1, idx + 10, true);
				DFS(idx + 1);
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, false);
				change(cameras.get(idx).x, cameras.get(idx).y, i + 1 == 4 ? 0 : i + 1, idx + 10, false);
			}
			break;
		case 4:
			for (int i = 0; i < dx.length; i++) {
				for (int j = 0; j < dx.length; j++) {
					if (i == j)
						continue;
					change(cameras.get(idx).x, cameras.get(idx).y, j, idx + 10, true);
				}
				DFS(idx + 1);
				for (int j = 0; j < dx.length; j++) {
					if (i == j)
						continue;
					change(cameras.get(idx).x, cameras.get(idx).y, j, idx + 10, false);
				}
			}
			break;
		case 5:
			for (int i = 0; i < dx.length; i++) {
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, true);
			}
			DFS(idx + 1);
			for (int i = 0; i < dx.length; i++) {
				change(cameras.get(idx).x, cameras.get(idx).y, i, idx + 10, false);
			}
			break;
		}
	}

	// 시작위치 x,y 방향 dir, 감시지역이 되면(set) -1로 변경/백트랙킹이면(!set) 0으로 변경
	private static void change(int x, int y, int dir, int num, boolean set) {
		// TODO Auto-generated method stub
		// 벽(6)을 만날때까지 해당 방향으로 쭈욱 -1 덮어씌운다
		// 0과 -1(다른 cctv 보고있는 상태일뿐)
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (set) {
			while (true) {
				if (!inMap(nx, ny))
					return;
				if (map[nx][ny] == 6)
					return;
				if (map[nx][ny] == 0) {
					map[nx][ny] = num; // 사각지대 아니다
				}
				nx += dx[dir];
				ny += dy[dir];

			}
		} else {
			while (true) {
				if (!inMap(nx, ny))
					return;
				if (map[nx][ny] == 6)
					return;
				if (map[nx][ny] == num) {
					map[nx][ny] = 0; // 다시 빈칸으로
				}
				nx += dx[dir];
				ny += dy[dir];
			}
		}
	}

}
