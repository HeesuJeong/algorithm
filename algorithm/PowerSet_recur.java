package 금요일;

public class PowerSet_recur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3,5,1};
		powerset(arr,0,new boolean[arr.length]);
		subsum(arr,0,0);
	}
	static void subsum(int[] arr,int idx,int sum) {
		if(idx==arr.length) {
			System.out.println(sum);
			return;
		}
		subsum(arr,idx+1,sum+arr[idx]);
		subsum(arr,idx+1,sum);
	}
	static void powerset(int[] arr,int idx,boolean[] sel) {
		if(idx==arr.length) {
			for (int i = 0; i < arr.length; i++) {
				if(sel[i]) System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		sel[idx]=true;
		powerset(arr,idx+1,sel);
		sel[idx]=false;
		powerset(arr,idx+1,sel);
	}

}
