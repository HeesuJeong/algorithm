package 상호배타집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 종교_정올 {
	static int[] parents;
	static int[] rank;
	private static StringTokenizer xy;

	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);
		// int N = sc.nextInt();//(0 < n ≤ 50,000)
		// int M = sc.nextInt();//( 0 ≤ m ≤ 100,000 )

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N과 M을 입력받고 싶은데
		StringTokenizer nm = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(nm.nextToken());
		int M = Integer.parseInt(nm.nextToken());

		parents = new int[N + 1];
		rank = new int[N + 1];
		// makeSet
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer xy = new StringTokenizer(br.readLine());
			union(Integer.parseInt(xy.nextToken()), Integer.parseInt(xy.nextToken()));
		}

		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (i == parents[i])
				cnt++;
		}
		System.out.println(cnt);

	}

	static int find(int x) {
		int tmp = x;
		while (tmp != parents[tmp]) {
			tmp = parents[tmp];
		}
		parents[x] = tmp;
		int root= tmp;
		tmp = x;
		while (tmp != parents[tmp]) {
			tmp = parents[tmp];
			parents[tmp] = root;
		}
		return tmp;
	}

	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		// parents[py] = px;
		if (rank[px] < rank[py]) {
			parents[px] = py;
		} else {
			parents[py] = px;
			if (rank[px] == rank[py]) {
				rank[px]++;
			}
		}
	}

}
