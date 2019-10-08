import java.util.Arrays;
import java.util.Scanner;

//민석이의 과제 체크하기
public class _5431 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();

		int[] student=new int[101];
		int[] sorting = new int[101];
		for (int i = 1; i <= TC; i++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			for(int j=0;j<K;j++) {
				int hw=sc.nextInt();
				student[hw]=1;
			}//for j
			//for(int j=0;j<=N;j++) System.out.println(student[j]);
			int idx=0;
			for(int j=1;j<=N;j++) {
				if(student[j]==0) {
					sorting[idx++]=j;
				}
			}
			//for(int j=0;j<=N;j++) System.out.println(sorting[j]);
			Arrays.sort(sorting,1,N-K);
			
			System.out.print("#"+i+" ");
			for(int j=0;j<N-K;j++) System.out.print(sorting[j]+" ");
			System.out.println();
			//초기화
			for(int j=0;j<=N;j++) {student[j]=0;}
			for(int j=0;j<=idx;j++) {sorting[j]=0;}
		}//for i
	}

}
