import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0,1,4,9,16,25,36,49,64,81,100,121,144,169};
		//사용자로부터 정수를 입력받아서 해당 숫자의 제곱보다 작은 제곱수 중 가장 큰 값을 찾으시오
		int N=arr.length;
		//Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Scanner sc=new Scanner(System.in);
		
		int find=0;
		find=sc.nextInt();
		
		
		
		int idx=N/2;
		int left=0; 
		int right=N-1;
		//작거나 같은걸 찾으라면 right의 값이 최대값
		//크거나 같은걸 찾으라면 left가 최소값
		while(left<=right) {
			//왼쪽에 있는 경우
			if(arr[idx]>find) {
				right=idx-1;
				idx=(left+right)/2;
			}
			//오른쪽에 있는 경우
			else if(arr[idx]<find){
				left=idx+1;
				idx=(left+right)/2;
			}
			else if(arr[idx]==find) {
				right=idx;
				break;
			}
		}
		if(right<0) System.out.println("없다");
		else{System.out.println("답 "+arr[right] );
		}
		
	}

}
