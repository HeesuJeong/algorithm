package 수요일;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 감시_다시 {
	static int N;
	static int M;
	static int[][] map;

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
	}

	static ArrayList<info> cameras;
	// 0빈칸, 6은 벽,1~5 카메라
	// 카메라는 카메라 통과 가능
	// 카메라는 벽 통과 불가
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 }; // 상하좌우
	static int[][][] DIR = { // dx,dy의 인덱스가 될거야
			{},
			{ { 0, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 1, 0, 0 }, { 1, 0, 0, 0 } }, // 1번 카메라
			{ { 0, 0, 1, 1 }, { 1, 1, 0, 0 } }, // 2번 카메라(좌우/상하 가능하다)
			{ { 1, 0, 0, 1 }, { 0, 1, 0, 1 }, { 0, 1, 1, 0 }, { 1, 0, 1, 0 } }, // 3번 카메라
			{ { 1, 1, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 1 }, { 0, 1, 1, 1 } }, // 4번 카메라
			{ { 1, 1, 1, 1 } }, // 5번 카메라
	};

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int[N][M];
		cameras = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 1 && map[i][j] != 6)
					cameras.add(new info(i, j, map[i][j]));
			}
		}
		dirArr = new int[cameras.size()];
		result=Integer.MAX_VALUE;
		DFS(0);
		System.out.println(result);
	}

	static int[] dirArr;
	static int result;
	private static void DFS(int idx) {
		// TODO Auto-generated method stub
		if (idx == cameras.size()) {
			//System.out.println("출력 :"+Arrays.toString(dirArr));
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < cameras.size(); i++) {
				int x = cameras.get(i).x;
				int y = cameras.get(i).y;
				int kind = cameras.get(i).kind;
				for (int j = 0; j < 4; j++) {
					// 고른 덩어리의 사방 탐색
					if (DIR[kind][dirArr[i]][j] == 1) {
						int nx = x + dx[j];
						int ny = y + dy[j];
						while (true) {
							if (!inMap(nx, ny) || map[nx][ny] == 6) //기저(벗어나거나 벽 만나면)
								break;
							visited[nx][ny]=true;
							nx+=dx[j];
							ny+=dy[j];
						}
					}
				}
			}
			int cnt=0;
			for (int i = 0; i <N; i++) {
				for (int j = 0; j <M; j++) {
					if(map[i][j]==0&&visited[i][j]==false) cnt++;
				}
			}
			result=Math.min(result, cnt);
			
			return;
		}
						//idx번째 카메라의 종류에는 몇 개의 세트가 존재하는가
		for (int i = 0; i < DIR[cameras.get(idx).kind].length; i++) {// 한 카메라의 가능한 감시방향세트 고르기
			dirArr[idx] = i;// 해당 카메라가 어느 방향세트를
			DFS(idx + 1);
		}
	}

}
