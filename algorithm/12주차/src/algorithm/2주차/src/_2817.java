import java.util.Scanner;
//비트연산 부분집합
public class _2817 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
				int T = sc.nextInt();
				int N = 0;
				int K = 0;
				int[] arr = new int[21];

				for (int TC = 1; TC <= T; TC++) {
					int CNT=0;
					N = sc.nextInt();
					K = sc.nextInt();
					for (int i = 0; i < N; i++) {
						arr[i] = sc.nextInt();
					}

					for (int i = 0; i < (1 << N); i++) {
						// System.out.println(i);
						int sum = 0;
						for (int j = 0; j < N; j++) {
							// System.out.println("j : "+j);
							if (((1 << j) & i) != 0) {
								sum += arr[j];
							}
						}

						if (sum == K)
							CNT++;
					}

					System.out.println("#"+TC+" " + CNT);
				} // TC
	}

}
