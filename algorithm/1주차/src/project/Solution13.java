//빌딩
package project;

import java.util.Arrays;
import java.util.Scanner;

//빌딩 세울 수 있는 곳  B 공원 G
//가로,세로,대각선 에 공원 있다면 빌딩은 무조건 2층높이
//인접구획에 G 없다면 빌딩은 가로와 세로의 B의 수만큼 높이 (자신 포함)
//가장 높은 빌딩은 몇층인가?

public class Solution13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
		
		int[][] arr = new int[21][21];
		int TC = sc.nextInt();
		int N = 0;
		int max = 0;
		for (int i = 1; i <= TC; i++) {
			N = sc.nextInt();
			max = 0;
			// 입력받기
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					char tmp = sc.next().charAt(0);
					// 공원은 -1 빌딩가능은 0
					if (tmp == 'G')
						arr[j][k] = -1;
					if (tmp == 'B')
						arr[j][k] = 0;
				}
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					int cnt = 0;
					boolean chk = false;
					// 빌딩 가능 지역
					if (arr[j][k] == 0) {
						// 주위에 공원 있는지 확인
						for (int l = 0; l < 8; l++) {
							int nx=j+dx[l]; int ny=k+dy[l];
							if (nx < 0 || nx >= N ||  ny< 0 || ny >= N)
								continue;
							if (arr[nx][ny]==-1) {
								chk = true;
							}
						}
						// 주위에 공원 없다면
						if (chk == false) {
							// 가로와 세로 쭈욱 훑기
							for (int l = 0; l < N; l++) {
								if (arr[j][l] == 0)
									cnt++;
								if (arr[l][k] == 0)
									cnt++;
							}
							cnt--; // 자기 자신은 두번 세워지므로
						}
					} // 빌딩 가능 지역 발견한 경우
					if (max < cnt) {
						max = cnt;
					}
				}
			}
			
			System.out.println("max " + max);
			
			// 초기화
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = 0;
				}
			}
			
		} // for TC
	}

}
