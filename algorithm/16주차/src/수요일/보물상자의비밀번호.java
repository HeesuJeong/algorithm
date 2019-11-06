package 수요일;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 보물상자의비밀번호 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			String str = "";
			LinkedList<String> li = new LinkedList<>();
			HashSet<String> set = new HashSet<>();
			str = sc.next();

			int idx = 0;
			String tmpStr = str;
			for (int i = 0; i < N / 4; i++) {
				int start = 0;
				while (true) {
					if (start==str.length())
						break;
					String tmp = tmpStr.substring(start, start + N/4);
					if (!set.contains(tmp)) {
						set.add(tmp);
						li.add(tmp);
					}
					start += N / 4;
				}
				tmpStr = "";
				tmpStr += str.substring(str.length() - 1);
				tmpStr += str.substring(0, str.length() - 1);
				str = tmpStr;
			}
			Collections.sort(li, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o2.compareTo(o1);
				}
			});
			String finalStr = li.get(K-1);
			int front = finalStr.length() - 1;
			int result = 0;
			int multi = 1;
			while (front >= 0) {
				// System.out.println(finalStr.charAt(front)+"?"+ multi);
				int operation = finalStr.charAt(front) - '0';
				if (operation > 9) {
					if (finalStr.charAt(front) == 'A')
						operation = 10;
					else if (finalStr.charAt(front) == 'B')
						operation = 11;
					else if (finalStr.charAt(front) == 'C')
						operation = 12;
					else if (finalStr.charAt(front) == 'D')
						operation = 13;
					else if (finalStr.charAt(front) == 'E')
						operation = 14;
					else if (finalStr.charAt(front) == 'F')
						operation = 15;
				}
				result += (operation * multi);
				front--;
				multi *= 16;
			}
			System.out.println("#" + tc + " " + result);

		} // tc
	}

}
