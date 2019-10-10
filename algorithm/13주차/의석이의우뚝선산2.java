package 목요일;

import java.util.Scanner;

public class 의석이의우뚝선산2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		
		for (int tc = 1; tc <=TC; tc++) {
			int N=sc.nextInt();
			int[] arr=new int[N];
			for (int i = 0; i <N; i++) {
				arr[i]=sc.nextInt();
			}
			int result=0;
			int up=0;
			int down=0;
			for (int i = 0; i < arr.length-1; i++) {
				if(arr[i]<arr[i+1]) {//증가구간
					//새로운 block일때 이전 block의 우뚝선산 계산해둬
					if(down>0) {
						result+=up*down;
						up=0;
						down=0;
					}
					up++;
				}else {//감소구간
					down++;
				}
			}
			result+=up*down;
			System.out.println("#"+tc+" "+result);
		}//tc
	}

}
