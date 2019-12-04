package 수요일;

import java.util.Scanner;

public class 유니온파인드 {

	static int V;
	static int E;
	static int[] parents;
	static int[] ranks;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		V=sc.nextInt();
		E=sc.nextInt();
		parents=new int[V+1];
		ranks=new int[V+1];
		//make set: 해당 원소를 집합의 식별자로 하는 새로운 집합을 생성
		for (int i = 0; i <parents.length; i++) {
			parents[i]=i;
			ranks[i]=1;
		}
		for (int i = 0; i <E; i++) {
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			union(v1,v2);
		}
		int result=0;
		for (int i = 1; i < parents.length; i++) {
			if(i==parents[i]) result++;
		}
		System.out.println("집합의 개수는 : "+result);
	}

	//두 대표자간 한 쪽을 부모로 설정함
	private static void union(int x, int y) {
		// TODO Auto-generated method stub
		int px=findSet(x);
		int py=findSet(y);
		if(px!=py) {
			if(ranks[px]>ranks[py]) {
				parents[py]=px;
			}
			else {
				parents[px]=py;
				if(ranks[px]==ranks[py]) {
					ranks[py]++;
				}
			}
		}
	}

	//해당 원소가 속한 집합의 대표자를 찾는 연산
	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if(x==parents[x]) return x;
		return parents[x]=findSet(parents[x]);   //path compression
	}

}
