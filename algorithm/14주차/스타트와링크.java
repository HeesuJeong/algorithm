package 목요일;

import java.util.Arrays;
import java.util.Scanner;

public class 스타트와링크 {

	//조합(반띵)
	static int N;
	static int[][] map;
	static int[] result1;
	static int[] result2;
	static int[] arr;
	static int result;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		arr=new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i+1;
		}
		map=new int[N+1][N+1];
		result1=new int[N/2];
		result2=new int[N/2];
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <=N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		result=Integer.MAX_VALUE;
		combi(0,0);
		System.out.println(result);
	}

	private static void combi(int n, int c) {
		// TODO Auto-generated method stub
		/*System.out.println("n은? "+n);
		if(n==N/2) return;*/
		if(result1.length==c) {
			int idx=0;
			for (int i = 0; i < arr.length; i++) {
				int now=arr[i];
				boolean find=false;
				for (int j = 0; j < result1.length; j++) {
					if(now==result1[j]) find=true;
				}
				if(find==false) result2[idx++]=now;
			}
			int startTotal=cal(result1);
			int linkTotal=cal(result2);
			result=Math.min(result, Math.abs(startTotal-linkTotal));
		return;	
		}
		if(arr.length==n) return;
		result1[c]=arr[n];
		combi(n+1,c+1);
		combi(n+1,c);
	}

	private static int cal(int[] result) {
		// TODO Auto-generated method stub
		int sum=0;
		for (int i = 0; i <result1.length; i++) {
			for (int j = 0; j <result2.length; j++) {
				sum+=map[result[i]][result[j]];
			}
		}
		return sum;
	}

}
