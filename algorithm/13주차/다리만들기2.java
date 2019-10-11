package 금요일;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.InputMap;

public class 다리만들기2 {

	static int N;
	static int M;
	static int[][] map; // 바다 0 육지1
	static boolean[][] visited;
	static int[] parents; // 크루스칼위해
	static int islandCnt;
	static int[][] infoArr;

	static class info {
		int x;
		int y;

		public info(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		islandCnt = 1;// 섬의 개수

		// BFS로 섬들에 numbering하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j] == false) {
					visited[i][j] = true;
					BFS(i, j, islandCnt);
					islandCnt++; // 섬의 개수 세기
				}
			}
		}
		islandCnt -= 1; // 섬의 총 갯수
		infoArr = new int[islandCnt * islandCnt + 1][3];

		makeBridge();
		
		// Kruskal 부분
		// 가중치로 정렬
		parents = new int[islandCnt + 1];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
		//링크드리스트로 바꾸자&**************************************
		Arrays.sort(infoArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		int result = 0;
		boolean chk = false;
		int cnt = 0; // 간선 몇 개 선택했는지
		for (int i = 0; i < staticIdx; i++) {
			int px = findSet(infoArr[i][0]);
			int py = findSet(infoArr[i][1]);
			// 같은 집합 아니라면
			if (px != py) {
				cnt++; // 간선 선택했다.
				result += infoArr[i][2];
				union(px, py);
				if (cnt == islandCnt - 1) {
					// mst완성
					System.out.println("들어ㅘ?");
					chk = true;
					break;
				}
			}
		}
		if (chk)
			System.out.println(result);
		else
			System.out.println("-1");
	}

	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if (x == parents[x])
			return x;
		parents[x] = findSet(parents[x]);
		return parents[x];
	}

	private static void union(int px, int py) {
		// TODO Auto-generated method stub
		parents[px] = py;
	}

	// 아래,오른쪽
	static int[] moveX = { 1, 0 };
	static int[] moveY = { 0, 1 };
	static int staticIdx = 0;

	private static void makeBridge() {
		// TODO Auto-generated method stub
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) { // 섬이라면 다리 건설 시도하기
					for (int k = 0; k < 2; k++) {
						int ni = i + moveX[k];
						int nj = j + moveY[k];
						if (inMap(ni, nj) && map[ni][nj] == 0) {
							// 오른쪽이나 아래로 다리 시도 할 수 있는 경우이다.
							int cnt = 0;
							while ((inMap(ni, nj))) {
								if (map[ni][nj] > 0) {
									if (cnt >= 2) {
										infoArr[staticIdx][0] = map[i][j];
										infoArr[staticIdx][1] = map[ni][nj];
										infoArr[staticIdx][2] = cnt;
										//System.out.printf("%d %d %d\n", infoArr[staticIdx][0], infoArr[staticIdx][1],
												//infoArr[staticIdx][2]);
										staticIdx++;
									}
									break;
								}
								cnt++;
								ni += moveX[k];
								nj += moveY[k];
							}
						}
					}
				}
			}
		}
	}

	private static void BFS(int x, int y, int number) {
		// TODO Auto-generated method stub
		Queue<info> q = new LinkedList<>();
		map[x][y] = number;
		q.add(new info(x, y));

		while (!q.isEmpty()) {
			info tmp = q.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if (inMap(nx, ny) && map[nx][ny] == 1 && visited[nx][ny] == false) {
					visited[nx][ny] = true;
					map[nx][ny] = number;
					q.add(new info(nx, ny));
				}
			}
		}
		// 섬들 사이에 최소의 거리 찾아 저장해둔다.
	}

}

/*
 * for (int i = 0; i < map.length; i++) { for (int j = 0; j < map[i].length;
 * j++) { System.out.print(map[i][j]+" "); } System.out.println(); }
 * System.out.println("섬의 개수는 "+islandCnt);
 */