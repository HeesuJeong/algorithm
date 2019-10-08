package 금요일;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] original= {{1,2},{3,4}};
		change(original);
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.println(original[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		System.out.println("일차원");
		int[] original2= {1,2};
		change(original2);
		for (int i = 0; i < original2.length; i++) {
			System.out.print(original2[i]+" ");
		}
		
		
		
	}
	static void change(int[][] o) {
		o[0][0]=99;
	}
	static void change(int[] o) {
		o[0]=99;
	}
}
