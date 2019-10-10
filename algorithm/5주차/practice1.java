package 금요일;

import java.util.Scanner;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "0000000111100000011000000111100110000110000111100111100111111001100111";

		int start = 0;
		int end = 7;

		int num = 0;
		while (end <= str.length()) {
			String binary = str.substring(start, end);

			for (int i = 0; i < 7; i++) {
				num += (binary.charAt(7 - 1 - i) - '0') * (1 << i);
			}

			start += 7;
			end += 7;
		}

		System.out.println(num);
	}

}
