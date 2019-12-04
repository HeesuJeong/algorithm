import java.util.Arrays;
import java.util.Scanner;

public class _2063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr=new int[200];
		int[] cntArr=new int[200];
		int N;
		int input;
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		for(int i=0;i<N;i++) {
			input=sc.nextInt();
			cntArr[input]++;
		}
		
		//System.out.println(Arrays.toString(cntArr));
		
		//N이 7인 경우에 N/2는 3이다.
		//인덱스 3인 것에 들어가는 값이 필요하기 때문에
		//누적값-1이 자기 자리이므로 sum>find이다.
		int find=N/2;
		int sum=0;
		int resul=0;
		for (int i = 0; i < cntArr.length; i++) {
			sum+=cntArr[i];
			if(sum>find) {
				resul=i;
				break;
			}
			cntArr[i]=sum;
		}
		//System.out.println(Arrays.toString(cntArr));
		System.out.println(resul);
	}//main

}
