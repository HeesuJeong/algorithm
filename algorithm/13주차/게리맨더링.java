package 목요일;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 게리맨더링 {

	// N개 지역이 두 선거구로 나뉘어
	// 선거구는 공집합 안 돼, 선거구 내 모든 구역 연결되어야해
	static int N;
	static int[] arr; // 인구수 저장
	static int[][] map; // 인접 정보
	static int[] set;
	static int[] set1;
	static int[] set2;
	static int result;
	static boolean[] visited;
	static int allPopulation;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		set = new int[N];
		for (int i = 0; i < set.length; i++) {
			set[i] = i + 1;
		}
		result = Integer.MAX_VALUE; 
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			allPopulation+=arr[i]; //전체 인구수 저장
		}
		// 인접행렬 만들기
		for (int i = 0; i < arr.length; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int tmp = sc.nextInt();
				map[i + 1][tmp] = 1;
				map[tmp][i + 1] = 1;
			}
		}

		int combiCnt = N / 2;
		// 조합 만들기
		for (int i = 1; i <= combiCnt; i++) {
			set1 = new int[i]; // 한 선거구
			set2 = new int[N - i];// 나머지 선거구
			combi(0, 0,0);
		}
		if(result==Integer.MAX_VALUE) {// 두 선거구 나눌 수 없는 경우
			System.out.println("-1");
		}
		else {
			System.out.println(result);
		}
	}// main

	private static void combi(int n, int c,int sumSet1) {
		// TODO Auto-generated method stub
		if (c == set1.length) {
			int idx = 0;
			for (int i = 0; i < set.length; i++) {
				boolean find = false;
				for (int j = 0; j < set1.length; j++) {
					if (set[i] == set1[j]) {
						find = true;
						break;
					}
				}
				if (!find)
					set2[idx++] = set[i];
			}
			// 두 선거구 나뉘어졌으므로
			// 각 선거구가 reachable한지 판단하쟈
			boolean chk1=reachable(set1[0], set1,set2);
			boolean chk2=reachable(set2[0], set2,set1);
			//두 선거구 잘 나뉘어진 경우 최솟값 구하쟈
			if(chk1&&chk2) {
				/*System.out.println(Arrays.toString(set1)+" 인구수는 "+sumSet1);
				System.out.println(Arrays.toString(set2)+" 인구수는 "+(allPopulation-sumSet1));
				System.out.println("차이는 "+Math.abs(sumSet1-(allPopulation-sumSet1)));
				System.out.println("============");*/
				int tmp=Math.abs(sumSet1-(allPopulation-sumSet1));
				result=Math.min(tmp, result);
			}
			return;
		}
		if (n == set.length)
			return;
		set1[c] = set[n];
		combi(n + 1, c + 1,sumSet1+arr[n]);
		combi(n + 1, c,sumSet1);
	}

	// BFS
	private static boolean reachable(int start, int[] set,int[] set2) {
		// TODO Auto-generated method stub
		Arrays.fill(visited, false);
		Queue<Integer> q = new LinkedList<Integer>();
		visited[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < map.length; i++) {
				boolean in=false;
				//같은 선거구인지 확인
				for (int j = 0; j < set.length; j++) {
					if(i==set[j]) {in=true;break;}
				}
				if(!in) continue; //같은 선거구 아니라면 pass
				
				
				//다른 선거구에 포함된거면 pass
				boolean notin=false;
				for (int j = 0; j < set2.length; j++) {
					if(i==set2[j]) {notin=true;break;}
				}
				if(notin) continue;
				
				
				//같은 선거구&&연결&&방문안했다면
				if (map[tmp][i] == 1 && visited[i] == false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	
		boolean chk=true;
		//BFS 다 돌았는데 false인 경우가 있다면 해당 선거구는 연결되지 않은 경우
		for (int i = 0; i < set.length; i++) {
			if(visited[set[i]]==false) {
				chk=false; break;
			}
		}
		return chk;
	}

}
