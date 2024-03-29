import java.util.Arrays;
import java.util.Scanner;
//햄버거다이어트 
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

			int maxScore = 0;
			for (int i = 0; i < (1 << N); i++) {
				int sumCal = 0;
				int sumScore = 0;
				for (int j = 0; j < N; j++) {
					if (((1 << j) & i) != 0) {
						if (sumCal + cal_arr[j] <= L) {
							sumCal += cal_arr[j];
							sumScore += score_arr[j];
						}
					}
				}
				if(maxScore<sumScore) maxScore=sumScore;
			}
			
			System.out.println("#"+tc+" "+maxScore);
		} // TC
	}// main

}
