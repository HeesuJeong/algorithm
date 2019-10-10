package 금요일;

import java.util.Arrays;
import java.util.Scanner;

public class 부분수열의합 {

	static int[] arr;
	static boolean[] visited;
	static int result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			arr=new int[N];
			visited=new boolean[N];
			result=0;
			for (int i = 0; i < arr.length; i++) {
				arr[i]=sc.nextInt(); 
			}
			powerset(0,K);
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void powerset(int idx,int k) {
		// TODO Auto-generated method stub
		if(idx==arr.length) {
			int sum=0;
			for (int i = 0; i < arr.length; i++) {
				if(visited[i]==true) sum+=arr[i];
			}
			if(sum==k) result++;
			return;
		}
		visited[idx]=true;
		powerset(idx+1,k);
		visited[idx]=false;
		powerset(idx+1,k);
	}

}
