import java.util.Scanner;

//홀수마방진
//위의 왼쪽으로, 이미 존재하면 기존의 아랫칸
public class 마방진 {

	static int N;
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		int num = 1;
		map[0][N / 2] = num;
		input(0, N / 2, num + 1);
		// map[1][1]=99;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		if (check())
			System.out.println("마방진입니다");
		else
			System.out.println("마방진 아닙니다");
	}

	private static boolean check() {
		// TODO Auto-generated method stub\

		// 행검사
		boolean row = true;
		int totalsum = 0;
		int tmpsum = 0;
		for (int i = 0; i < N; i++) {
			tmpsum = 0;
			for (int j = 0; j < N; j++) {
				if (i == 0)
					totalsum += map[i][j];
				else {
					tmpsum += map[i][j];
				}
			}
			if (i != 0 && totalsum != tmpsum) {
				row = false;
				break;
			}
		}
		// 열검사
		boolean col = true;
		tmpsum = 0;
		totalsum = 0;
		for (int i = 0; i < N; i++) {
			tmpsum = 0;
			for (int j = 0; j < N; j++) {
				if (i == 0)
					totalsum += map[j][i];
				else
					tmpsum += map[j][i];
			}
			if (i != 0 && totalsum != tmpsum) {
				col = false;
				break;
			}
		}
		// 대각선검사
		boolean cross = true;
		tmpsum = 0;
		totalsum = 0;
		for (int i = 0; i < N; i++) {
			totalsum += map[i][i];
			tmpsum += map[i][N - 1 - i];
		}
		if (totalsum != tmpsum) {
			cross = false;
		}
		System.out.println("행,열,대각선의 각각의 합은 " + totalsum + " 입니다.");

		if (col && row && cross)
			return true;
		else
			return false;
	}

	private static void input(int x, int y, int num) {
		// TODO Auto-generated method stub
		if (num == N * N + 1)
			return;

		int tmpX = x - 1 < 0 ? N - 1 : x - 1;
		int tmpY = y - 1 < 0 ? N - 1 : y - 1;
		if (map[tmpX][tmpY] != 0) {
			tmpX = x + 1 >= N ? 0 : x + 1;
			tmpY = y;
		}
		// 왼쪽 위 가능한경우
		map[tmpX][tmpY] = num;
		input(tmpX, tmpY, num + 1);
	}

}
