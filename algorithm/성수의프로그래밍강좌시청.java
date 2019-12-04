import java.util.Arrays;
import java.util.Scanner;

public class 성수의프로그래밍강좌시청 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*double tmp=2;
		System.out.printf("%.6f",tmp);*/
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			int[] arr=new int[N];
			for (int i = 0; i <N; i++) {
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			double now=0;
			for (int i = arr.length-K; i < arr.length; i++) {
				now=(now+arr[i])/2;
			}
			System.out.printf("#%d %.6f\n",tc,now);
			
		}//tc
	}

}
