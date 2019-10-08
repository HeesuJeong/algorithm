package 수요일;

import java.util.Scanner;

public class 계산기 {

	static int TC;
	static int N;
	static Scanner sc=new Scanner(System.in);
	static int[] arr;
	static int resul;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			resul=0;
			N=sc.nextInt();
			arr=new int[N];
			for (int i = 0; i < N; i++) {
				arr[i]=sc.nextInt();
			}
			recur(1,arr[0]);
			System.out.println("#"+tc+" "+resul);
		}//tc
	}
	static void recur(int c,int sum) {
		if(c==arr.length) {
			resul=Math.max(resul, sum);
			return;
		}
			recur(c+1,sum*arr[c]);
			recur(c+1,sum+arr[c]);
		
	}
}
