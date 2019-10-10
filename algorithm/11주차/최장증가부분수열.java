package 목요일;

import java.util.Arrays;
import java.util.Scanner;

public class 최장증가부분수열 {

	static int[] arr;
	static int[] store;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			int num=sc.nextInt();
			arr=new int[num+1];
			store=new int[num+1]; //인덱스가 길이
			for (int i = 0; i < num; i++) {
				arr[i]=sc.nextInt();
			}
			for (int i = 0; i < num; i++) {
				int now=arr[i];
				for (int j = 1; j <store.length; j++) {
					if(store[j]==0||now<store[j]) {
						store[j]=now;
						break;
					}
				}
			//	System.out.println(Arrays.toString(store));
			}
			int max=-1;
			for (int i = 1; i < arr.length; i++) {
				if(store[i]==0) {
					max=i;
					break;
				}
			}
			max--;
			System.out.println("#"+tc+" "+max);
		}//tc
	}

}
