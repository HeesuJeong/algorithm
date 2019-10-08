package 수요일;

import java.util.Arrays;

public class 퀵정렬 {

	static int[] arr= {4,3,2,1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		quickSort(0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void quickSort(int l,int r) {
		if(l<r) {
			int s=partition(l,r);
			quickSort(l, s-1);
			quickSort(s+1, r);
		}
	}
	
	static int partition(int l,int r) {
		int x=arr[r];
		int i=l;
		for (int j = l; j < r; j++) {
			if(arr[j]<=x) {
				int tmp=arr[i];
				arr[i]=arr[j];
				arr[j]=tmp;
				i++;
			}
		}
		int tmp=arr[i];
		arr[i]=arr[r];
		arr[r]=tmp;
		return i;
	}
}
