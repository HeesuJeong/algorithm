package 수요일;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 특이한자석 {

	static LinkedList<Integer>[] li;
	static int K;
	static int[][] command;
	static int[] state;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int K = sc.nextInt();
			command = new int[K][2];// 움직일 자석 번호(-1해서 인덱스 접근할거야), 방향(1시계 -1반시계 0그대로)
			li = new LinkedList[4];
			for (int i = 0; i < li.length; i++) {
				li[i] = new LinkedList<>();
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					li[i].add(sc.nextInt()); // 0N 1S
				}
			}
			for (int i = 0; i < K; i++) {
				command[i][0] = sc.nextInt();
				command[i][1] = sc.nextInt();
			}

			// 게임시작
			for (int i = 0; i < K; i++) {
				int start = command[i][0] - 1;// 처음 움직이는 자석 번호
				int startdir = command[i][1];
				state = new int[4];
				// 내 다음들 보기
				int me = start;
				int medir = startdir;
				state[me] = startdir; // 내가 해당 방향으로 회전하는 것은 무조건!
				while (true) {
					if (me == 3) {
						// 내가 마지막여이였다면 내 다음 안 봐
						break;
					} else {// 내 다음 있다면 같이 방향 정해줘야해
						int com1 = li[me].get(2);
						int com2 = li[me + 1].get(6);
						if (com1 == com2) {
							// 내 오른쪽들은 방향 안 바꿀거니깐 기본값 0으로 둬
							// 더 이상의 오른쪽들 볼 필요 없으니깐 break
							break;
						} else {// 다른 경우 연달아 오른쪽들 방향 바꿔줘야해
							state[me + 1] = medir * (-1);
							me += 1;
							medir *= (-1);
						}
					}
				}
				// 내 이전들 보기
				while(true) {
					if(me==0) break;//내가 젤 왼쪽이면 더이상 왼쪽 안 봐
					else {
						int com1 = li[me].get(6);
						int com2 = li[me - 1].get(2);
						if (com1 == com2) {
							break;//내 왼쪽들 안 바껴
						}else {
							state[me - 1] = medir * (-1);
							me -= 1;
							medir *= (-1);
						}
					}
				}
				for (int j = 0; j < 4; j++) {
					int dir=state[j]; //i번 좌석 상태
					if(dir==1) {//시계방향(마지막이 맨 앞으로)
						li[j].addFirst(li[j].pollLast());
					}else if(dir==-1) {//반시계방향(맨 앞이 마지막으로)
						li[j].addLast(li[j].pollFirst());
					}
				}
			}
			//게임 끄읕(인덱스 0보기)
			int result=0;
			for (int j = 0; j < 4; j++) {
				result+=li[j].get(0)==0?0:Math.pow(2, j);
			}
			System.out.println("#"+tc+" "+result);
		} // tc
	}

}
