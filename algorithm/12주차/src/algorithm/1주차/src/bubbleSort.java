import java.util.Arrays;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 55, 7, 78, 12, 42 };

		int tmp = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}// class끝

}
