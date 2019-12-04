package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//나랑 가장 가까운 제곱근을 찾아
public class 현주가좋아하는제곱근놀이 {

	static long[] arr = new long[1000001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i * (long) i; // int곱하기int는 자동으로 int형에 담기게 된다.
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			long N = Long.parseLong(br.readLine());
			int result = 0;
			while (N >2) {
				long min = 1;
				long max = arr.length - 1;
				while (min <= max) {
					long mid =(min + max) / 2;
					long midValue=arr[(int) mid];
					if(N==midValue) {
						result+=(midValue-N);
						result++;
						N=mid;
						System.out.println("N "+N);
						break;
					}
					if (N < midValue) {
						max = mid - 1;
					} else if (N > midValue) {
						min = mid + 1;
					}
				}
			}
			System.out.println("#"+tc+" "+result);
		} // tc
	}

}
