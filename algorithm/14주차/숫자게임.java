package 월요일;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 숫자게임 {
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = 0;
			int input=Integer.parseInt(br.readLine());
			dfs(input, 0);
			bw.append("#").append(String.valueOf(tc)).append(" ").append(String.valueOf(ans)).append("\n");
		}
		bw.flush();
	}

	static void dfs(int number, int turn) {
		if (number < 10) { // dfs의 기저로 파고 들어왔을때 현재 숫자가 한자리수면 그놈은 답의 후보
			ans = Math.max(turn, ans);
			return;
		}
		int divided2 = 10;
		while (true) {
			if (number < divided2) // 2덩어리로 나누려고 들어왔는데 현재 숫자가 한자리수면 나눌 수가 없으니 반복문 탈출
				break;
			int a = number / divided2;
			int b = number % divided2;
			dfs(a * b, turn + 1);
			divided2 *= 10;
			int divided3 = 10;
			while (true) {
				if (b < divided3) // 3덩어리로 나누려고 들어왔는데 현재 숫자가 한자리수면 나눌 수가 없으니 반복문 탈출
					break;
				int b_a = b / divided3;
				int b_b = b % divided3;
				dfs(a * b_a * b_b, turn + 1);
				divided3 *= 10;
				int divided4 = 10;
				while (true) {
					if (b_b < divided4) // 4덩어리로 나누려고 들어왔는데 현재 숫자가 한자리수면 나눌 수가 없으니 반복문 탈출
						break;
					int b_b_a = b_b / divided4;
					int b_b_b = b_b % divided4;
					dfs(a * b_a * b_b_a * b_b_b, turn + 1);
					divided4 *= 10;
					int divided5 = 10;
					while (true) {
						if (b_b_b < divided5) // 5덩어리로 나누려고 들어왔는데 현재 숫자가 한자리수면 나눌 수가 없으니 반복문 탈출
							break;
						int b_b_b_a = b_b_b / divided5;
						int b_b_b_b = b_b_b % divided5;
						dfs(a * b_a * b_b_a * b_b_b_a * b_b_b_b, turn + 1);
						divided5 *= 10;
					}
				}
			}
		}
	}
}