import java.util.ArrayList;
import java.util.Scanner;

public class 색종이만들기 {

	static int N;
	static int[][] arr;
	static int blue; // 1로 색칠
	static int white; // 0으로 색칠
	static ArrayList<Integer> li;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		li = new ArrayList<>();
		int tmp = N;
		while (tmp != 0) {
			li.add(tmp);
			tmp /= 2;
		}
		//System.out.println(li.toString());

		cut(0, 0, 0);
		System.out.println(white);
		System.out.println(blue);
	}// main

	private static void cut(int idx, int x, int y) {
		// TODO Auto-generated method stub
		if (idx == li.size())
			return;
		if (x >= N || y >= N)
			return;

		int color = arr[x][y];
		int len = li.get(idx);
		boolean out = false;
		
		loop: for (int i = x; i < x + len; i++) {
			for (int j = y; j < y + len; j++) {
				if ((i < N && j < N) && arr[i][j] != color) {
					cut(idx + 1, x, y);
					cut(idx + 1, x, y + len/2);
					cut(idx + 1, x + len/2, y);
					cut(idx + 1, x + len/2, y + len/2);
					out = true;
					break loop;
				}
			}
		}
		// 같은 색으로 모두 색칠
		if (out == false) {
			if (color == 1) {
				//System.out.println(x + " blue " + y);
				blue++;
			} else {
				//System.out.println(x + " white " + y);
				white++;
			}
		}
	}

}
