package 금요일;

import java.util.Arrays;

public class 조합 {

	static int[] arr={1,2,3,4};
	static int[] result=new int[3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		combination(0,0);
	}

	private static void combination(int idx, int r_idx) {
		// TODO Auto-generated method stub
		if(r_idx==result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		if(idx==arr.length) return;
		
		result[r_idx]=arr[idx];
		combination(idx+1, r_idx+1); //넣는다
		combination(idx+1,r_idx); //안 넣는다
	}

}
