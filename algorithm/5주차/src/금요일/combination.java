package 금요일;

import java.util.Arrays;

public class combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,1,4,5,2};
		combination(arr,0,0,new int[3]);
	}
	static void combination(int[] arr,int n,int c,int[] sel) {
		if(c==sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(n==arr.length) return;
		
		sel[c]=arr[n];
		//n번째에 대해서  sel에 담고 지나가
		combination(arr,n+1,c+1,sel);
		//n번째에 대해서 sel에 안담고 지나가기
		combination(arr,n+1,c,sel);
	} 

}
