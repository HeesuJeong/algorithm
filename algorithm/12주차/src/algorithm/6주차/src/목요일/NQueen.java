package 목요일;

import java.util.Arrays;
import java.util.Scanner;

public class NQueen {

	static Scanner sc = new Scanner(System.in);
	static int N;
	static int[][] map;
	final static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	final static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int cnt;
	static int T;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T=sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {			
			cnt=0;
			N = sc.nextInt();
			map = new int[N][N];
			backtrack(0);
			System.out.println("#"+tc+" "+cnt);
		}
	}

	static boolean inMap(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	static void backtrack(int idx) {
		if (idx == map.length) {
			cnt++;
			return;
		}
		for (int i = 0; i < map[idx].length; i++) {
			if (canBeNQueen(idx, i)) {
				map[idx][i] = 1;
				backtrack(idx + 1);
				map[idx][i] = 0;
			}
		}
	}

	static boolean canBeNQueen(int r, int c) {
		for (int i = r - 1; i >= 0; i--) {
			if (map[i][c] == 1) {
				return false;
			}
		}
		for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1)
				return false;
		}
		for (int i = r - 1, j = c + 1; i >= 0 && j < map[i].length; i--, j++) {
			if (map[i][j] == 1)
				return false;
		}
		return true;
	}
}
