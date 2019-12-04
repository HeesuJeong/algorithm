package 수요일;

import java.util.Arrays;
import java.util.Scanner;

public class 재관이의대량할인 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			int n=sc.nextInt();
			int[] arr=new int[n];
			int sum=0;
			for (int i = 0; i < n; i++) {
				arr[i]=sc.nextInt();
				sum+=arr[i];
			}
			Arrays.sort(arr);
			int idx=n-3;
			int result=0;
			while(idx>=0) {
				result+=arr[idx];
				idx-=3;
			}
			System.out.println("#"+tc+" "+(sum-result));
		
		}//tc
	}

}
