package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {

	static int n;
	static int[] parents;
	static int[] ranks;
	static int m;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); //정점 수 정점은 0번부터 n까지 n+1개
		parents=new int[n+1];
		ranks=new int[n+1];
		for (int i = 0; i < parents.length; i++) {
			parents[i]=i;
			ranks[i]=1;
		}
		m=Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st=new StringTokenizer(br.readLine());
			int comm=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int pa=findSet(a);
			int pb=findSet(b);
			if(comm==0) { //합집합
				if(pa!=pb) union(pa,pb);
			}else if(comm==1) {//같은 집합 여부?
				if(pa!=pb) System.out.println("NO");
				else System.out.println("YES");
			}
		}
	}

	private static void union(int pa, int pb) {
		// TODO Auto-generated method stub
		if(ranks[pa]>ranks[pb]) {
			parents[pb]=pa; //더 작은게 큰걸루 들어가
		}else {
			parents[pa]=pb;
			if(ranks[pa]==ranks[pb]) ranks[pb]++;
		}
	}

	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if(x==parents[x]) return x;
		return parents[x]=findSet(parents[x]);
	}

}
