package 목요일;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 나무재테크 {

	static int N;
	static int M;
	static int K;
	static int[][] many; // 겨울에 추가할 양분
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static boolean inMap(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= N;
	}

	static int[][] map; // 각 칸의 현 양분
	static PriorityQueue<Integer>[][] pq; // 한 (r,c)에 여러 나무가 있다면 나이 순으로 정렬할 필요가 있으므로
	static PriorityQueue<Integer> tmpPq;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		many = new int[N + 1][N + 1];
		pq = new PriorityQueue[N + 1][N + 1];
		
		map = new int[N + 1][N + 1]; // 처음 양분은 모두 5
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 입력과 pq배열
				many[i][j] = sc.nextInt(); //겨울에 추가할 양분 양 저장
				map[i][j] = 5;
				pq[i][j] = new PriorityQueue<Integer>(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return Integer.compare(o1, o2);
					}
				});
			}
		}
		for (int i = 0; i < M; i++) {
			int tmpX = sc.nextInt();
			int tmpY = sc.nextInt();
			int age = sc.nextInt();
			pq[tmpX][tmpY].add(age); // 각 위치에 나무 나이 입력
		}
		// 봄여름가을겨울 시작
		while (K > 0) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// 나무가 있다면 양분 먹자
					int howMany = map[i][j];
					tmpPq=new PriorityQueue<>(); //************
					if (pq[i][j].size() != 0) {
						//poll과 add 하는 경우에는 iterator쓰지 말자, 포인터 길 잃어ㅠㅠ
						while (!pq[i][j].isEmpty()) {
							int age = pq[i][j].peek();
							// 나무 나이가 적어서 양분 먹을 수 있는 경우
							if (age <= howMany) {
								pq[i][j].poll();
								tmpPq.add(age + 1); //살아있는 얘는 tmpPQ에 저장해둬야지
								howMany -= age;
								map[i][j] = howMany;
							} else {
								// 양분 부족으로 죽은 경우(여름)
								int dieAge = pq[i][j].poll();
								dieAge /= 2;
								map[i][j] += dieAge;
							}
						}
						pq[i][j]=tmpPq;//살아있는얘 다시 본래 pq에 저장!
					}
				}
			}
			// 가을
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (pq[i][j].size() != 0) {
						Iterator<Integer> it = pq[i][j].iterator();
						//pq돌기만 하기 때문에 iterator사용해도 돼
						while (it.hasNext()) {
							int age = it.next();
							// 나이가 5의 배수이면 8방향에 나이 1인 나무 심어
							if (age % 5 == 0) {
								for (int k = 0; k < 8; k++) {
									int nx = i + dx[k];
									int ny = j + dy[k];
									if (inMap(nx, ny)) {
										pq[nx][ny].add(1);
									}
								}
							}
						}
					}
				}
			}
			// 겨울
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[i][j] += many[i][j];
				}
			}
			K--;
		}
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (pq[i][j].size() != 0)
					result += pq[i][j].size();
			}
		}
		System.out.println(result);
	}

}
