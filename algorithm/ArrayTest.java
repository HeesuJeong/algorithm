import java.util.Scanner;

//연습문제 
//낙하시키는 문제 => 가장 많이 낙하한 것의 낙하개수 찾기
/*10
1 9 3 5 2 1 6 9 3 5
>7

10
7 5 0 3 4 3 7 2 7 4
>7

10
5 5 4 6 1 3 1 8 8 7
>4*/

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int input = 0;

		for (int i = 0; i < N; i++) {
			input = sc.nextInt();
			for (int k = 0; k < input; k++)
				arr[i][k] = 1;
		}

		/*for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("===============");*/

		int cnt = 0;
		int max=0;
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					// 내가 맨 아래줄이 아니고, 내 아랫줄이 1 아니라면
					// 반복해서 아래로 내리고 카운트++
					int cur_row = i;
					cnt = 0;
					while (cur_row != N - 1 && arr[cur_row + 1][j] != 1) {
						arr[cur_row][j]--;
						arr[cur_row + 1][j]++;
						cnt++;
						cur_row++;
					}
				}
			}
			if(max<cnt) max=cnt;
		}
		System.out.println("결과 "+max);
		
		
		/*// 입력 잘 되었는지 확인하기 위해
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}*/

	}// main끝
}
