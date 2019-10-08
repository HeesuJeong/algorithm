package 수요일;

import java.util.Scanner;

public class 거듭제곱 {

	static int a;
	static int b;
	static Scanner sc= new Scanner(System.in);
	static int cnt1;
	static int cnt2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a=sc.nextInt();
		b=sc.nextInt();
		System.out.println(pow(a,b));
		System.out.println(pow2(a,b));
		System.out.println(cnt1);
		System.out.println(cnt2);
	}
	
	//분할정복
	static int pow(int a,int b) {
		cnt1++;
		if(b==1) {
			//b가 홀수
			return a;
		}
		int tmp=pow(a,b/2);
		if(b%2==1) return tmp*tmp*a;
		else return tmp*tmp;
	}
	//재귀
	static int pow2(int a,int b) {
		cnt2++;
		if(b==1) return a;
		return a*pow2(a,b-1);
	}
}
