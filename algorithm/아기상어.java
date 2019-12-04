package 목요일;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어 {

	static int[][] map;
	static int N;
	static boolean[][] visited;

	static class shark {
		int x;
		int y;
		int size;
		int cntEat;

		public shark(int x, int y, int size, int cntEat) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.size = size;
			this.cntEat = cntEat;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static class posi implements Comparable<posi> {
		int x;
		int y;
		int dist;

		public posi(int x, int y, int dist) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(posi o) {
			// TODO Auto-generated method stub
			int ret = 0;
			if (Integer.compare(this.dist, o.dist) > 0)
				ret = 1;
			else if (Integer.compare(this.dist, o.dist) == 0) {
				if (Integer.compare(this.x, o.x) > 0)
					ret = 1;
				else if (Integer.compare(this.x, o.x) == 0) {
					if (Integer.compare(this.y, o.y) > 0)
						ret = 1;
					else if (Integer.compare(this.y, o.y) == 0)
						ret = 0;
					else
						ret = -1;
				} else
					ret = -1;
			} else
				ret = -1;
			return ret;
		}
	}

	static PriorityQueue<posi> pq;
	static shark baby;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		pq = new PriorityQueue<>();
		int result = 0; // 결과로 사용할 시간을 더할거얌
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int tmp = sc.nextInt();
				if (tmp == 9)
					baby = new shark(i, j, 2, 0);
				else
					map[i][j] = tmp;
			}
		}
		boolean chk = true;
		while (chk) {
			Queue<posi> q = new LinkedList<>();
			q.add(new posi(baby.x, baby.y, 0)); // 아기상어 처음위치
			visited[baby.x][baby.y] = true;
			boolean chkchk=true;
			while (!q.isEmpty()) {
				posi tmp = q.poll();
				//System.out.println("무한");
				for (int i = 0; i < 4; i++) {
					int nx = tmp.x + dx[i];
					int ny = tmp.y + dy[i];
					int nd = tmp.dist + 1;
					// 물고기가 상어보다 작거나 같으면 이동 가능
					if (inMap(nx, ny) && baby.size >= map[nx][ny] && !visited[nx][ny]) {
						visited[nx][ny]=true;
						q.add(new posi(nx, ny, nd));
						// 작으면 먹을 수 잇다 =>후보군 저장
						if (map[nx][ny] < baby.size&&map[nx][ny]!=0) {
							pq.add(new posi(nx, ny, nd));
						}
					}
				}
			}
			if (!pq.isEmpty()) {
				posi move = pq.peek();
				result += move.dist;
				baby.x = move.x;
				baby.y = move.y;
				baby.cntEat++;
				if (baby.cntEat == baby.size) {
					baby.size++;
					baby.cntEat = 0;
				}
				map[move.x][move.y]=0; //***************
				pq.clear();
				for (int i = 0; i < N; i++) {
					Arrays.fill(visited[i],false);
				}
			} else {
				chk=false;
			}
		}
			System.out.println(result);
		}
}
