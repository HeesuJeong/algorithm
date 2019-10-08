package 수요일;

import java.util.Arrays;

public class perm_recur {

	static void swap(int[] arr,int a,int b) {
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}
	static int[] arr= {1,2,3};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perm(0);
	}

	static void perm(int k) {
		if(k==arr.length) {
			System.out.println(Arrays.toString(arr));
		}else {
			for (int i = k; i < arr.length; i++) {
				swap(arr,i,k);
				perm(k+1);
				swap(arr,i,k);
			}
		}
	}
}
