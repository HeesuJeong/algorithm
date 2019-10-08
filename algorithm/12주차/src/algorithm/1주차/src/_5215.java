import java.util.Scanner;

//햄버거 다이어트(망망망)
//0/1 Knapsack => 부분집합

public class _5215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 재료의수 1 ≤ N ≤ 20
			int L = sc.nextInt(); // 제한 칼로리 1 ≤ L ≤ 10^4
			int[] score_arr = new int[N];
			int[] cal_arr = new int[N];
			for (int i = 0; i < N; i++) {
				score_arr[i] = sc.nextInt();
				cal_arr[i] = sc.nextInt();
			}
			MAX = 0;
			solve(score_arr, cal_arr, 0, 0, 0, L);
			System.out.println("#" + tc + " " + MAX);
		}
	}

	static int MAX = 0;

	static void solve(int[] score_arr, int[] cal_arr, int score_sum, int cal_sum, int idx, int L) {

		if (cal_sum > L)
			return;
		if (idx == score_arr.length) {
			if (MAX < score_sum)
				MAX = score_sum;
			return;
		}
		solve(score_arr, cal_arr, score_sum + score_arr[idx], cal_sum + cal_arr[idx], idx + 1, L);
		solve(score_arr, cal_arr, score_sum, cal_sum, idx + 1, L);

	}

}
