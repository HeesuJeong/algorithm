package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 도시분할계획 {

	static int N;
	static int M;

	static class info implements Comparable<info> {
		int from;
		int to;
		int cost;

		public info(int from, int to, int cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(info o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}

	}

	static ArrayList<info> krus;
	static int[] parents;
	static int[] ranks;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		krus = new ArrayList<>(); // 크루스칼 위해서
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			krus.add(new info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(krus);
		krus.remove(M-1);
		/*for (int i = 0; i < krus.size(); i++) {
			System.out.println(krus.get(i).from + " " + krus.get(i).to + " " + krus.get(i).cost);
		}
		System.out.println("=====");*/
		parents=new int[N+1]; //집은 1번부터
		for (int i = 0; i < parents.length; i++) {
			parents[i]=i;
		}
		ranks=new int[N+1];
		Arrays.fill(ranks, 1);
		int select=0;
		int sum=0;
		int idx=0;
		while(true) {
			if(select==N-2) {
				System.out.println(sum);
				break;
			}
			info tmp=krus.get(idx++);
			int x=tmp.from;
			int y=tmp.to;
			int cost=tmp.cost;
			int px=findParent(x);
			int py=findParent(y);
			if(px!=py) {
				//System.out.println(x+" "+y+"일때 "+cost);
				select++;
				sum+=cost;
				union(px,py);
			}
		}
	}
	private static void union(int px, int py) {
		// TODO Auto-generated method stub
		if(ranks[px]<ranks[py]) {
			parents[px]=py; //랭크 큰 데에 작은 것을 붙인다
		}else if(ranks[py]<ranks[px]) {
			parents[px]=py; 
		}else {//랭크 같은 경우
			parents[px]=py;
			ranks[py]++; //py높이 높아진다.
		}
	}
	private static int findParent(int x) {
		// TODO Auto-generated method stub
		if(x==parents[x]) return x;
		return parents[x]=findParent(parents[x]);
	}

}
