package 금요일;
//시간초과 뜨는 코드이다
//그리디로 다시 풀어야한다.
import java.util.Scanner;

public class 의석이의우뚝선산 {

	static int[] arr;
	static int result = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			result = 0;
			int N = sc.nextInt();
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < N - 2; i++) {
				for (int j = i+2; j < N; j++) {
					func(i, j);
				}
			}
			System.out.println("#" + tc + " " + result);
		} //
	}

	private static void func(int start, int end) {
		// TODO Auto-generated method stub
		boolean chk = true;
		boolean middle = false;
		for (int i = start; i < end; i++) {
			if (i == start && arr[i] > arr[i + 1]) {
				chk = false; // 시작이 다음보다 크면 무조건 안 되는 경우
				break;
			}
			if (middle == false) {
				if (arr[i] < arr[i + 1]) {
					middle = false;
				} else if (arr[i] > arr[i + 1]) {
					middle = true; // 커지다가 작아지는 부분을 true
					i--;
				}
			} else if (middle) {
				if (arr[i] < arr[i + 1]) {
					chk = false; // 계속 작아져야 하는데 중간에 다시 커지면 안 돼
				}
			}
		}
		if(middle==false) chk=false;
		if (chk) {
			result++;
		}
	}

}
