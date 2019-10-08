import java.util.Arrays;
import java.util.Scanner;

//Flatten
public class _1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[101];

		Scanner sc = new Scanner(System.in);
		int dump_num = 0;
		int height = 0;

		for (int i = 1; i <= 10; i++) {
			int max = 0;
			int min = 101;
			int maxIdx = 0;
			int minIdx = 101;
			dump_num = sc.nextInt();
			//가로 100개의 높이 받기
			for (int j = 0; j < 100; j++) {
				arr[j] = sc.nextInt();
				if (min > arr[j]) {
					min = arr[j];
					minIdx = j;
				}
				if (max < arr[j]) {
					max = arr[j];
					maxIdx = j;
				}
			} // for j
			
			//System.out.println(Arrays.toString(arr));
			
			//dump수만큼 돌리기
			int gap=0;
			for (int j = 0; j < dump_num; j++) {
				gap=max-min;
				if(gap==0||gap==1) break;
				arr[minIdx]+=1;
				min+=1;
				arr[maxIdx]-=1;
				max-=1;
				for(int k=0;k<100;k++) {
					if (min > arr[k]) {
						min = arr[k];
						minIdx = k;
					}
					if (max < arr[k]) {
						max = arr[k];
						maxIdx = k;
					}
				}//for k
				gap=max-min;
				//System.out.println("max min"+max+" "+min);
				
			}//for j
			
			System.out.println("#"+i+" "+gap);
			
		} // for TC

	}

}
