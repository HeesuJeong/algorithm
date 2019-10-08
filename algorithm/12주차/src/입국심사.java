import java.util.Arrays;
import java.util.Scanner;

public class 입국심사 {

	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N];
			int maxTime=0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				maxTime=Math.max(maxTime, arr[i]);
			}
			long min = 1;
			long max = (long)maxTime * M;
			//min는 되는 최소값이
			//max는 안 되는 최대값이 존재하게 된다
			while (min <= max) {
				long middle = (min + max) / 2;
				long num = 0;
				for (int i = 0; i < arr.length; i++) {
					num += middle / arr[i];
				}
				if (num < M) {
					min = middle+1;
				} else if (num >= M) {
					//크거나 같으면 앞을봐
					max = middle-1;
				}
			}
			System.out.println("#"+tc+" "+min);
		} // tc
	}

}
