package 수요일;

import java.util.Scanner;

public class BSearch {
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11,13,15};
		int low = 0;
		int high = arr.length-1;
		
		int key = new Scanner(System.in).nextInt();
		int mid = 0;
		while( low <= high) {
			mid = (low+high)/2;
			if( arr[mid] == key) {
				high=mid;
				break;
			}
			else if(arr[mid] < key) {
				low = mid+1;
			}
			else
				high = mid-1;
		}
//		System.out.println(low);
		System.out.println(high);
	}
}
