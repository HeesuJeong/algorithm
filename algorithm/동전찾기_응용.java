import java.util.Arrays;

public class 동전찾기_응용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coin = { 1, 5,10,16};
		int[] arr = new int[101];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		//System.out.println(Arrays.toString(arr));
		for (int i = 1; i < coin.length; i++) {
			int coinType=coin[i];
			for (int j = coinType; j < arr.length; j++) {
					arr[j]=Math.min(arr[j-coinType]+1, arr[j]);
			}
			//System.out.println(Arrays.toString(arr));
		}
		System.out.println(arr[100]);
	}

}
