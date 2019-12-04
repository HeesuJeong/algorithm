import java.util.Scanner;

public class 자기방으로돌아가기2 {

	static int T;
	static int N;
	static int stuNum;
	static Scanner sc = new Scanner(System.in);
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			arr = new int[201];
			for (int k = 0; k < N; k++) {

				int tmp = sc.nextInt();
				int tmp2 = sc.nextInt();
				if (tmp2 < tmp) {
					for (int i = (tmp2 + 1) / 2; i <= (tmp + 1) / 2; i++) {
						arr[i]++;
					}
				} else {
					for (int i = (tmp + 1) / 2; i <= (tmp2 + 1) / 2; i++) {
						arr[i]++;
					}
				}
			}
			int resul = 0;
			for (int i = 0; i < arr.length; i++) {
				int find = arr[i];
				resul = Math.max(resul, find);
			}
			System.out.println("#" + tc + " " + resul);
		}
	}

}
