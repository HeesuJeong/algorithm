package 목요일;

import java.util.Scanner;

public class _1로만들기 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] arr=new int[N+1];
		arr[1]=1;
		arr[2]=1;
		arr[3]=1;
		for (int i = 4; i <=N; i++) {
			arr[i]=arr[i-1]+1;
			if(i%2==0)
				arr[i]=Math.min(arr[i],arr[i/2]+1);
			if(i%3==0)
				arr[i]=Math.min(arr[i],arr[i/3]+1);
		}
		System.out.println(arr[N]);
	}

}

