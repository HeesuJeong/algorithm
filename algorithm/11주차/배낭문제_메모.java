package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class 배낭문제_메모 {
	static int N;
	static int K;
	static int[] weights;
	static int[] values;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			weights = new int[N];
			values = new int[N];

			for (int i = 0; i < N; i++) {
				weights[i] = sc.nextInt();
				values[i] = sc.nextInt();
			}
			memo = new int[N][K+1];
			for(int i = 0; i < N; i++)
				Arrays.fill(memo[i], -1);
			System.out.println("#" + tc + " " + dfs(0, 0));
		}
	}
	static int[][] memo;
	static int dfs(int idx, int weight) {
		if (idx == N) { //물건 없는 경우 가치 더할 거 없쥬~
			return 0;
		}
		if(memo[idx][weight] != -1 ) //계산 되어 있지 않는 경우 가져다 쓴다
			return memo[idx][weight];
		// 못담는 경우
		if (weight + weights[idx] > K) {
			memo[idx][weight] = dfs(idx + 1, weight);
			return memo[idx][weight];
		} else //담을 수 있는 경우
			memo[idx][weight] = Math.max(
					dfs(idx + 1, weight),  //안 담을래!
					values[idx] + dfs(idx + 1, weight + weights[idx])); //담을래!
			return memo[idx][weight]; //더 큰 값을 저장하고 리턴!
	}
}
