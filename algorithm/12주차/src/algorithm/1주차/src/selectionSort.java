import java.util.Arrays;

/*선택정렬
인덱스 0부터 훑어서 가장 큰 값 인덱스 0으로 swap
인덱스 1부터 훑어서 두번째 큰 값 인덱스 1로 swap
...*/
public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 4, 2, 8, 9, 6, 3, 5, 0, 1 };

		for (int j = 0; j < arr.length; j++) {
			int max = arr[j]; // 첫 친구가 가장 작다고 가정
			int max_index = j;
			// arr배열 0번째부터 끝까지 중에 가장 큰 값을 찾아서 max에 저장하고, 그 위치를 max_index에 저장

			int tmp = 0;
			for (int i = j; i < arr.length; i++) {
				if (max < arr[i]) {
					max = arr[i];
					max_index = i;
				}
			} // for i 끝
			tmp = arr[j];
			arr[j] = arr[max_index];
			arr[max_index] = tmp;
		} // for j 끝

		System.out.println(Arrays.toString(arr));
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
	}

}
