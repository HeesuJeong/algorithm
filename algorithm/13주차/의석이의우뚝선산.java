package 목요일;

import java.util.Scanner;

public class 의석이의우뚝선산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			int[] mountain; //산의 높이
			int result=0; 
			int N = sc.nextInt();
			mountain = new int[N];
			for(int i = 0; i < N; i++)
				mountain[i] = sc.nextInt();
			//올라가는 카운트와 내려가는 카운트..
			int up = 0;
			int down = 0;
			for (int i = 1; i < N; i++) {
				//올라가는 상황이면서,up과 down이 둘 다 0보다 크면
				//새로운 우뚝선 산의 시작이다 
				//up*down 만큼 우뚝선산 카운트
				if (mountain[i - 1] < mountain[i]) {
					if (down > 0) {
						// 새 block시작이므로 up,down초기화
						result += up * down;
						up = 0;
						down = 0;
					}
					up++;
				}
				else {
					down++;
				}
			}
			//
			result += up * down;
			System.out.println("#" + tc + " " + result);
		}//tc
	}

}
