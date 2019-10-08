package 금요일;

import java.util.Arrays;

public class 순열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3, 4 };
		permutation(arr, 0, new int[3], new boolean[arr.length]);
	}

	static void permutation(int[] arr, int c, int[] resul, boolean[] visited) {

		if(c==resul.length) {
			for (int i = 0; i < resul.length; i++) {
				System.out.print(resul[i]+" ");
			}
			System.out.println();
			return;
		}
		//if(c==arr.length) return;
		
		for (int i = 0; i < arr.length; i++) {
			if (visited[i] == false) {
				resul[c] = arr[i];
				visited[i] = true;
				permutation(arr, c + 1, resul, visited);
				visited[i] = false;
			}
		}
	}

}
