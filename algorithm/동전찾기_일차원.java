import java.util.Arrays;

public class 동전찾기_일차원 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coin = { 1, 4, 6 };
		int[] arr = new int[200];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < coin.length; i++) {
			int coinType=coin[i];
			for (int j = 0; j < arr.length; j++) {
				if(j>=coinType) {
					arr[j]=Math.min(arr[j-coinType]+1, arr[j]);
				}
			}
			System.out.println(Arrays.toString(arr));
		}
		System.out.println(arr[178]);
	}

}
