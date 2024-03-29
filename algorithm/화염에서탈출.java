package 금요일;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 화염에서탈출 {

	static int R;
	static int C;

	static boolean inMap(int x, int y) {
		return (x >= 0 && x < R && y >= 0 && y < C);
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;

	static class posi {
		int x;
		int y;
		int time;

		public posi(int x, int y, int time) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static Queue<posi> q = new LinkedList<posi>();
	static int hx, hy; // 집 위치
	static int sx = 0, sy = 0; // 시작위치
	static int result = -1; // 0이상이면 집 도착 가능한 것

	// 이동 가능은 0 바위 -1 집 -2 불 처음 위치 -3
	// 불은 바위와 집만 이동 불가능

	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer rc=new StringTokenizer(br.readLine());
		R = Integer.parseInt(rc.nextToken());
		C = Integer.parseInt(rc.nextToken());
		map = new int[R][C];
		visited=new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str=br.readLine();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				if (c == 'S') {// 시작 위치
					sx = i;
					sy = j;
				} else if (c == '*') { // 불을 큐에 저장
					q.add(new posi(i, j, 1));
					map[i][j] = 1;
				} else if (c == 'D') {// 집 위치
					hx = i;
					hy = j;
					map[i][j] = -2;
				} else if (c == 'X') {// 바위, 이동 불가능
					map[i][j] = -1;
				}
			}
		} // 입력 끝
		bfs(); //불 퍼트리기
		q.add(new posi(sx,sy,1));
		map[sx][sy]=1;
		move();
		if(result>0) System.out.println(result-1);
		else System.out.println("impossible");
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		while (!q.isEmpty()) {
			posi np = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = np.x + dx[i];
				int ny = np.y + dy[i];
				int nt = np.time;
				if (inMap(nx, ny) && map[nx][ny] == 0) {
					map[nx][ny] = nt + 1;
					q.add(new posi(nx, ny, nt + 1));
				}
			}
		}
	}
	
	//불이 없는 경우에는 방문 체크가 안 돼서 무한루프에 빠지게 돼
	static void move() {
		loop:while(!q.isEmpty()) {
			posi np = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = np.x + dx[i];
				int ny = np.y + dy[i];
				int nt = np.time+1;
				//집이면
				if(inMap(nx, ny)&&map[nx][ny]==-2) {
					result=nt;
					break loop;
				}
				if (inMap(nx, ny) &&visited[nx][ny]==false&&(map[nx][ny]>nt || map[nx][ny] == 0)) {
					map[nx][ny]=nt;
					q.add(new posi(nx, ny, nt));
				}
			}
		}
	}
}
