package 금요일;

import java.util.Arrays;

public class 순열 {

	static int[] arr= {1,2,3,4};
	static boolean[] visited=new boolean[arr.length];
	static int[] result=new int[3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perm(0);
	}
	private static void perm(int idx) {
		// TODO Auto-generated method stub
		if(idx==result.length) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(visited[i]==false) {
			result[idx]=arr[i];
			visited[i]=true;
			perm(idx+1);
			visited[i]=false;
			}
		}
	}

}
