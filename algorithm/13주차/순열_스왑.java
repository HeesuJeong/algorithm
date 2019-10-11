package 금요일;

import java.util.Arrays;

public class 순열_스왑 {
	//백트렉킹의 좋은 예시
	//성능은 이게 조금 더 빨라
	//원본을 바꾸기 때문에 결과 담을 배열 필요없어
	static int[] arr= {1,3,5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		perm(0);
	}
	static void perm(int idx) {
		if(idx==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			swap(i,idx);
			perm(idx+1);
			swap(i,idx);
		}
	}
	static void swap(int a, int b) {
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
	}

}
