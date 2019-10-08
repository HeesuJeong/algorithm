package 금요일;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= new int[9];
		Scanner sc=new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		combination(arr,0,0,new int[7]);
	}

	static boolean isFinished=false;
	
	static void combination(int[] arr,int n,int r,int[] brr) {
		
		if(r==brr.length) {
			if(isFinished) return;
			int sum=0;
			for (int i = 0; i < brr.length; i++) {
				sum+=brr[i];
			}
			if(sum==100) {
				isFinished=true;
			Arrays.sort(brr);
			for (int i = 0; i < brr.length; i++) {
				System.out.println(brr[i]);
			}
			}
			return;
		}
		if(n==arr.length) return;
		brr[r]=arr[n];
		combination(arr,n+1,r+1,brr);
		combination(arr,n+1,r,brr);
	}
}
