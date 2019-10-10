import java.util.Scanner;

public class ArrayTest2 {
	public static void main(String[] args) {
		int[] input = { 7, 4, 2, 0, 0, 6, 0, 7, 0, 0 };
		int max = 0;
		for (int i = 0; i < input.length; i++) {
			int cnt = 0;
			for (int j = i; j < input.length; j++) {
				if (input[i] > input[j])
					cnt++;
			}
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}
