package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 숫자게임 {

	static int N;
	static int result;
	static int[] splitArr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			N=Integer.parseInt(br.readLine());
			//N의 자를 수 있는 경우의 수를 뽑아보자
			//N-1까지의 부분집합구하기
			result=0;
			solve(N,0);
			System.out.println("#"+tc+" "+result);
		}//tc
	}
	private static void solve(int N, int cnt) {
		// TODO Auto-generated method stub
		if(N<10) {
			/*System.out.println("cnt는 "+cnt);
			System.out.println("============");*/
			result=Math.max(result, cnt);
			return;
		}
		String str=Integer.toString(N);
		int p=str.length()-1;
		//System.out.println("N은 "+N);
		for (int i = p; i >=1; i--) {
			int div=(int)Math.pow(10, i);
			for (int j = i; j >=0; j--) {
				int div2=(int)Math.pow(10, j);
				solve((N/div)*(N%div/div2)*(N%div2),cnt+1);
			}
			//System.out.println((N/div)+" "+(N%div)+"  i는 "+i);
		}
		
	}
	
}
