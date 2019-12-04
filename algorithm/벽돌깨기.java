package 수요일;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽돌깨기 {
	static int N, W, H;
	static int[][] map;
	static int[][] original;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			original = new int[H][W];
			permArr = new int[N];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					original[i][j]=sc.nextInt();
				}
			}
			result=Integer.MAX_VALUE;
			perm(0);
			System.out.println("#"+tc+" "+result);
		} // tc
	}
	static int result;
	static int[] permArr;
	static boolean[][] visited;
	static int[][] tmpArr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static boolean inMap(int x, int y) {
		return x >= 0 & x < H && y >= 0 && y < W;
	}
	private static int count(int[][] arr) {
		int cnt=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j <W; j++) {
				if(arr[i][j]!=0) cnt++;
			}
		}
		return cnt;
	}
	private static void perm(int cnt) {
		// TODO Auto-generated method stub
		if (cnt == permArr.length) { // N개 선택
			//System.out.println(Arrays.toString(permArr));
			// permArr배열에 담긴 중복순열 값으로 깨부셔보쟈
			map = new int[H][W];
			deepCopy(map,original);
			tmpArr = new int[H][W];
			for (int i = 0; i < permArr.length; i++) {
				int boll = permArr[i];
				deepCopy(tmpArr,map);
				visited = new boolean[H][W]; // 한 번 볼 떨어질때마다 필요한 방문배열
				play(boll, tmpArr);
			}
			
			result=Math.min(result,count(map));
			return;
		}
		for (int i = 0; i < W; i++) {
			permArr[cnt] = i;
			perm(cnt + 1);
		}
	}

	static class info {
		int x;
		int y;
		int num;

		public info(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	private static void play(int boll, int[][] arr) {
		// TODO Auto-generated method stub
		int startX = 0;
		int startY = boll;
		for (int i = 0; i < H; i++) { // 시작 행 찾기
			if (arr[i][boll] != 0) {
				startX = i;
				break;
			}
		}
		Queue<info> q = new LinkedList<info>();
		q.add(new info(startX, startY, map[startX][startY]));
		visited[startX][startY] = true;

		while (!q.isEmpty()) {
			info tmp = q.poll();
			int range = tmp.num - 1;// 상하좌우를 숫자-1 깊이만큼 탐색
			for (int i = 0; i < dx.length; i++) {
				int nx = tmp.x;
				int ny = tmp.y;
				for (int j = 0; j < range; j++) {
					nx += dx[i];
					ny += dy[i];
					if (inMap(nx, ny) && map[nx][ny] != 0 && visited[nx][ny] == false) {
						visited[nx][ny] = true;
						q.add(new info(nx, ny, map[nx][ny]));
					}
				}
			}
		}
		//visited된 것들 다 없애(원본 배열에 방문배열 및 tmpArr값 보면서 게임결과 갱신해)
		for (int i = 0; i < H; i++) {
			Arrays.fill(map[i],0);
		}
		for (int i = 0; i <W; i++) { //열 볼거야
			int idx=H-1;
			for (int j = H-1; j >=0; j--) {//행 본다
				if(arr[j][i]>0&&visited[j][i]==false) {
					map[idx--][i]=arr[j][i];
				}
			}
		}
	}

	private static void deepCopy(int[][] tmpArr,int[][] arr) {
		for (int i = 0; i < tmpArr.length; i++) {
			Arrays.fill(tmpArr[i],0);
		}
		for (int i = 0; i < tmpArr.length; i++) {
			for (int j = 0; j < tmpArr[i].length; j++) {
				tmpArr[i][j] = arr[i][j];
			}
		}
	}
}