import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr = { 7, 5, 6, 3, 4, 1, 2 };
		int[] arr= {8,3,7,4,10,20,1,99};
		
		int num = arr.length-1;
		while (num!=0) {
			for (int i = 0; i < num; i++) {
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
			}
			num-=1;
		}
		System.out.println(Arrays.toString(arr));
	}
}
