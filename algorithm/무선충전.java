package 수요일;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 무선충전 {
	static int[][][] map;
	static int[] moveA;
	static int[] moveB;
	static int M;
	static int A;
	static int[][] BC;

	// 그대로,상,우,하,좌
	static int[] dx = { 0, -1, 0, 1, 0 };
	static int[] dy = { 0, 0, 1, 0, -1 };

	static boolean inMap(int x, int y) {
		return x >= 1 && x <= 10 && y >= 1 && y <= 10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			map = new int[11][11][8]; // BC개수 최대 8이하이므로 최대 8개까지 한 칸에 겹칠 수 있다.
			M = sc.nextInt(); // 초
			A = sc.nextInt(); // 충전기 수
			moveA = new int[M + 1];// 총 이동 시간 20이상, 100이하
			moveB = new int[M + 1];
			// 시작점부터 충전되므로 '그대로'위치도 추가해서 총 M+1초 보자
			moveA[0] = 0;
			moveB[0] = 0;
			for (int i = 1; i <= M; i++) {
				moveA[i] = sc.nextInt();
			}
			for (int i = 1; i <= M; i++) {
				moveB[i] = sc.nextInt();
			}
			BC = new int[A][4];
			// 충전기 정보 저장(y,x,범위,용량)
			// 충전기 인덱스가 충전기 번호(i-1)
			for (int i = 0; i < A; i++) {
				for (int j = 0; j < 4; j++) {
					BC[i][j] = sc.nextInt();
				}
			}
			// 여러개 쌓였을때 용량 높은 순으로 쌓이도록 충전기배열을 정렬
			Arrays.sort(BC, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					int first = o1[3];
					int second = o2[3];
					return second - first;
				}
			});
			// 지도에 충전기 정보 뿌리기
			for (int i = 0; i < A; i++) {
				int nx = BC[i][1];
				int ny = BC[i][0];
				int range = BC[i][2];
				nx -= range;
				int idx = 1;
				for (int j = 0; j < range * 2 + 1; j++) {
					for (int k = 0; k < idx; k++) {
						if (!inMap(nx + j, ny + k))
							continue;
						// 이미 다른 BC 있는 경우 3차원 배열로 정보 쌓기
						for (int k2 = 0; k2 < map[0][0].length; k2++) {
							if (map[nx + j][ny + k][k2] == 0) {
								map[nx + j][ny + k][k2] = i + 1;
								//System.out.println((nx + j) + "," + (ny + k) + "," + k2 + "에서" + map[nx + j][ny + k][k2]);
								break;
							}

						}

					}
					// 매 행 시작점, 범위 갱신
					if (j < range) {
						ny--;
						idx += 2;
					} else {
						ny++;
						idx -= 2;
					}
				}
			}

			int sum=0;
			// 움직여보쟈
			int ax = 1, ay = 1, bx = 10, by = 10;
			for (int i = 0; i <= M; i++) {
				ax += dx[moveA[i]];
				ay += dy[moveA[i]];
				bx += dx[moveB[i]];
				by += dy[moveB[i]];
				// 같은 시간에 같은 충전기에 존재할때
				if (map[ax][ay][0] != 0 && map[ax][ay][0] == map[bx][by][0]) {
					// 2개 이상의 BC가 존재할 때,
					// 제일 큰것을 둘이 쪼개어 가지는 것보다 무조건 두 명이 다른걸 선택하는게 더 좋다
					// 단 BC가 하나라면 쪼개어 가져야해
					if (map[ax][ay][1] == 0&&map[bx][by][1] == 0) {
						//둘 다 하나이면
						sum += BC[map[ax][ay][0] - 1][3];
					} else {
						if(map[ax][ay][1] == 0) {
						sum+= BC[map[ax][ay][0] - 1][3]+ BC[map[bx][by][1] - 1][3];
						}else if(map[bx][by][1] == 0) {
							sum+= BC[map[ax][ay][1] - 1][3]+ BC[map[bx][by][0] - 1][3];
						}else {
							sum+=Math.max(BC[map[ax][ay][1] - 1][3]+ BC[map[bx][by][0] - 1][3], BC[map[ax][ay][0] - 1][3]+ BC[map[bx][by][1] - 1][3]);
						}
					}
				} else {
					if (map[ax][ay][0] != 0)
						sum += BC[map[ax][ay][0] - 1][3];
					if (map[bx][by][0] != 0) {
						sum += BC[map[bx][by][0] - 1][3];
					}
				}

			}
			System.out.println("#" + tc + " " + sum);
		} // tc
	}

}
