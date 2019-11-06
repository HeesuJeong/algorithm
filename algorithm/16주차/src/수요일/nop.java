package 수요일;

import java.util.Arrays;
import java.util.Scanner;

public class nop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[][] dp = new int[2][3];
		dp[0] = arr[0].clone();
		dp[1] = arr[1].clone();

		//최소
		int[][] dp2 = new int[2][3];
		dp2[0] = arr[0].clone();
		dp2[1] = arr[1].clone();
		int idx = 2;
		while (idx <= N) {
			dp[1][0] = Math.max(dp[1][0] + dp[0][0], dp[1][0] + dp[0][1]);
			dp2[1][0] = Math.min(dp2[1][0] + dp2[0][0], dp2[1][0] + dp2[0][1]);
			
			int tmp = Math.max(dp[1][1] + dp[0][0], dp[1][1] + dp[0][1]);
			int tmp2=Math.min(dp2[1][1] + dp2[0][0], dp2[1][1] + dp2[0][1]);
			tmp = Math.max(tmp, dp[1][1] + dp[0][2]);
			tmp2=Math.min(tmp2, dp2[1][1] + dp2[0][2]);
			dp[1][1] = tmp;
			dp2[1][1] = tmp2;
			
			dp[1][2] = Math.max(dp[1][2] + dp[0][2], dp[1][2] + dp[0][1]);
			dp2[1][2] = Math.min(dp2[1][2] + dp2[0][2], dp2[1][2] + dp2[0][1]);
			
			dp[0] = dp[1].clone();
			dp2[0] = dp2[1].clone();
			if (idx != N) {
				dp[1] = arr[idx].clone();
				dp2[1] = arr[idx].clone();
			}
				idx++;
			
		}
		/*for (int i = 0; i < dp[1].length; i++) {
			System.out.println(dp[1][i] + " ");
		}*/
		Arrays.sort(dp[1]);
		Arrays.sort(dp2[1]);
		int max = dp[1][2];
		int min = dp2[1][0];
		System.out.println(max+" "+min);
	}

}
