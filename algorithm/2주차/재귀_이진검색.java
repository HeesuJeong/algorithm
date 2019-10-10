//import java.util.Arrays;
//import java.util.Scanner;
//
//public class 재귀_이진검색 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int arr[] = { 1, 2, 5, 7, 9, 10, 15, 88, 100 };
//		int find = 0;
//		Scanner sc = new Scanner(System.in);
//		find = sc.nextInt();
//		int left = 0;
//		int right = arr.length - 1;
//		int mid = arr.length / 2;
//		recursive(arr, left, right, mid, find);
//	}
//
//	static public void recursive(int[] arr, int l, int r, int m, int f) {
//		if (l > r) {
//			System.out.println("없다.");
//			return;
//		}
//		if (arr[m] == f) {
//			System.out.println(m+"위치에 있습니다"100);
//			return;
//		}
//		if (arr[m] < f) {
//			l = m + 1;
//			m = (l + r) / 2;
//		} else if (arr[m] > f) {
//			r = m - 1;
//			m = (l + r) / 2;
//		}
//		recursive(arr, l, r, m, f);
//	}
//
//}
