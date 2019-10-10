import java.util.Scanner;

//몫과 나머지 출력하기
public class _2029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트케이스 입력

		for (int i = 1; i <= T; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			int q = a / b;
			int r = a % b;
			System.out.println("#" + i + " " + q + " " + r);
		}

	}

}
