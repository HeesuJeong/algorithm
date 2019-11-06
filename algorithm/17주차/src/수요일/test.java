package 수요일;

import java.util.Arrays;
import java.util.Comparator;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//이차원정렬 
		int[][] two=new int[3][2];
		two[0][0]=0;
		two[0][1]=10;
		two[1][0]=0;
		two[1][1]=5;
		two[2][0]=0;
		two[2][1]=7;
		Arrays.sort(two,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		for (int i = 0; i < two.length; i++) {
			System.out.println(Arrays.toString(two[i]));
		}
		//삼차원정렬
		int[][][] three=new int[1][1][6];
		three[0][0][0]=3;
		three[0][0][1]=5;
		three[0][0][2]=1;
		three[0][0][3]=8;
		three[0][0][4]=9;
		three[0][0][5]=2;
		Arrays.sort(three[0][0]);
			System.out.println(Arrays.toString(three[0][0]));
		
	}

}
