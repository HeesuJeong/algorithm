import java.util.Arrays;

public class permutation {

	static int[] arr= {1,2,3};
	static boolean[] visited=new boolean[arr.length];
	static int[] brr=new int[2];
	
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		perm(0);
	}

 	static void perm(int c) {
 		if(c==brr.length) {
 			System.out.println(Arrays.toString(brr));
 			return;
 		}
 		for (int i = 0; i < arr.length; i++) {
			if(visited[i]==false) {
				brr[c]=arr[i];
				visited[i]=true;
				perm(c+1);
				visited[i]=false;
			}
		}
 	}
}
