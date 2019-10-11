package 금요일;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 최소스패닝트리 {

	static int V;
	static int E;
	static int[][] map;
	static int[] parents;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		parents=new int[V+1]; //정점은 1번부터
		//makeset
		for (int i = 0; i < parents.length; i++) {
			parents[i]=i;
		}
		map=new int[E][3];
		for (int i = 0; i < map.length; i++) {
			map[i][0]=sc.nextInt();
			map[i][1]=sc.nextInt();
			map[i][2]=sc.nextInt();
		}
		//가중치로 정렬
		Arrays.sort(map,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		int result=0;
		int cnt=0; //간선 몇 개 선택했는지
		for (int i = 0; i < map.length; i++) {
			int px=findSet(map[i][0]);
			int py=findSet(map[i][1]);
			//같은 집합 아니라면
			if(px!=py) {
				cnt++; //간선 선택했다.
				result+=map[i][2];
				union(px,py);
				if(cnt==V-1) break;
			}
		}
		System.out.println(result);
	}

	private static void union(int px, int py) {
		// TODO Auto-generated method stub
		parents[px]=py;
	}

	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if(x==parents[x]) return x;
		parents[x]=findSet(parents[x]);
		return parents[x];
	}

}
