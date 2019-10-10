
public class 지그재그 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[][] arr= new int[3][4];
		

		int a=1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=a;
				a++;
			}
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j+(arr[i].length-1-2*j)*(i%2)]);
			}
			System.out.println();
		}
		
		
	}

}
