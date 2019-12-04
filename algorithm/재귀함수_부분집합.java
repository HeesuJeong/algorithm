import java.util.Arrays;

public class 재귀함수_부분집합 {
	public static void main(String[] args) {
		//boolean[] sel=new boolean[3];
		//powerset(sel,0);
		int[] arr= {1,2,3,4};
	}
	//부분집합의 경우 
//	static void powerset(boolean[] sel,int idx) {
//		if(idx==sel.length) {
//			System.out.println(Arrays.toString(sel));
//			return;
//		}
//		
//		sel[idx]=true;
//		powerset(sel,idx+1);
//		sel[idx]=false;
//		powerset(sel,idx+1);
//	}
	
	static void subsum(int[]arr,int idx, int sum) {
		if(idx==arr.length) {
			System.out.println(sum);
			return;
		}
		subsum(arr,idx+1,sum);
		subsum(arr,idx+1,sum+arr[idx]);
	}

}
