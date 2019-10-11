package 금요일;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2000*2000이므로 4방향 완탐 불가능
//depth마다 가장 빠른걸 선택해야해 (BFS)
public class 종구의딸이름짓기 {

	static char[][] map;
	static boolean[][] visited;
	// 오른쪽, 아래쪽
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };
	static int N;
	static int M;
	static StringBuilder sb;

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static class info {
		int x;
		int y;
		char c;

		public info(int x, int y, char c) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			sb = new StringBuilder();
			BFS();
			System.out.println("#"+tc+" "+sb.toString());
		} // tc

	}

	private static void BFS() {
		// TODO Auto-generated method stub
		Queue<info> q = new LinkedList<>();
		LinkedList<info> li;
		q.add(new info(0, 0, map[0][0]));
		visited[0][0] = true;
		sb.append(map[0][0]);// 스트링빌더에 붙이기

		while (!q.isEmpty()) {
			int sz = q.size();
			li = new LinkedList<>();
			for (int i = 0; i < sz; i++) {
				info tmp = q.poll(); // 큐에 있는거 다 빼
				// 큐의 오른쪽 아래쪽 다 저장
				for (int j = 0; j < dx.length; j++) {
					int nx = tmp.x + dx[j];
					int ny = tmp.y + dy[j];
					// 방문 가능하면 리스트에 저장
					if (inMap(nx, ny) && visited[nx][ny] == false) {
						char nc = map[nx][ny];
						visited[nx][ny] = true;
						li.add(new info(nx, ny, nc));
					}
				}
			} // sz
			if (!li.isEmpty()) {
				// 가장 작은 알파벳들을 알기 위해 정렬
				Collections.sort(li, new Comparator<info>() {

					@Override
					public int compare(info o1, info o2) {
						// TODO Auto-generated method stub
						return o1.c - o2.c;
					}
				});
				char min= li.get(0).c; // 가장 작은 알파벳

				sb.append(min); // 스트링빌더에 붙이기
				//System.out.println("sb: " + sb.toString());
				// aabc 같은 경우 다른 a 두개를 리스트에 넣어야 하기 때문에 갯수 확인
				int idx = 0;
				for (int k = 1; k < li.size(); k++) {
					if (min != li.get(k).c)
						break;
					idx++;
				}
				// 가장 작은 알파벳들 큐에 넣어
				for (int j = 0; j <= idx; j++) {
					q.add(li.get(j));
				}
			}//li.isEmpty
		} // q.isEmpty
	}

}
