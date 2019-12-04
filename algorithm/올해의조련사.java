package 수요일;

import java.util.LinkedList;
import java.util.Scanner;

public class 올해의조련사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int num = sc.nextInt();
			char[] arr = new char[num];
			for (int i = 0; i < num; i++) {
				arr[i] = sc.next().charAt(0);
			}
			StringBuilder sb = new StringBuilder();
			int front = 0;
			int back = arr.length - 1;
			while (front <= back) {
				char first = arr[front];
				char last = arr[back];
				if (front == back) {
					sb.append(last);
					break;
				}
				if (first < last) {
					sb.append(first);
					front++;
				} else if (first > last) {
					sb.append(last);
					back--;
				} else {
					int tf = front + 1;
					int tb = back - 1;
					boolean chk = false;
					while (tf <= tb) {
						if (arr[tf] > arr[tb]) {
							sb.append(last);
							back--;
							chk = true;
							break;
						} else if (arr[tf] < arr[tb]) {
							sb.append(first);
							front++;
							chk = true;
							break;
						} else {
							tf++;
							tb--;
						}
					}
					if (chk == false) {
						sb.append(last);
						back--;
					}
				}
			}
			System.out.println("#" + tc + " " + sb.toString());
		} // tc
	}

}
