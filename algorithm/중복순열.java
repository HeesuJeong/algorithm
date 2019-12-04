package 금요일;

import java.util.Arrays;

public class 중복순열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3};
		permutation(arr,0,new int[2]);
	}
	
	static void permutation(int[] arr,int c,int[] brr) {
		if(c==brr.length) {
			System.out.println(Arrays.toString(brr));
			return;
		}
		//if(c==arr.length) return;
		for (int i = 0; i < arr.length; i++) {
			brr[c] = arr[i];
			permutation(arr, c+1, brr);
		}
	}

}
