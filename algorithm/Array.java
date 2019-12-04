
public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr=new int[2][3];
		arr[0][1]=10;
		arr[1][2]=20;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
