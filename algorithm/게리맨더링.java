package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 게리맨더링 {
	static int N;
	static int M;
	static class node{
		int to;
		int cost;
		public node(int to,int cost) {
			// TODO Auto-generated constructor stub
			this.to=to;
			this.cost=cost;
		}
	}
	static ArrayList<node>[] map;
	static int[] arr;
	static int[] result1;
	static int[] result2;
	static int result=Integer.MAX_VALUE;
	static class info implements Comparable<info>{
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
			return this.cost-o.cost;
		}
	}
	static ArrayList<info> li1;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map=new ArrayList[N+1];
		for (int i = 0; i < map.length; i++) {
			map[i]=new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[v1].add(new node(v2, cost));
			map[v2].add(new node(v1, cost));
		}
		//두 마을로 쪼개기
		arr=new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i+1;
		}
		for (int i = 1; i <= N/2; i++) {
			result1=new int[i];
			result2=new int[N-i];
			combi(0,0);
		}
		System.out.println(result);
	}
	
	private static void combi(int n, int c) {
		// TODO Auto-generated method stub
		if(result1.length==c) {
			boolean[] chk=new boolean[N+1];
			for (int i = 0; i < result1.length; i++) {
				chk[result1[i]]=true;
			}
			int idx=0;
			for (int i = 1; i < chk.length; i++) {
				if(chk[i]==false) {
					result2[idx++]=i;
					if(idx==result2.length) break;
				}
			}
		boolean chk1=reachable(result1,result2);
		boolean chk2=reachable(result1,result2);
		if(chk1&&chk2) {
			//두 마을로 잘 나뉘었다면 mst만들기=>크루스칼
			parents=new int[N+1];
			//자기 자신을 부모로
			for (int i = 0; i <parents.length; i++) {
				parents[i]=i;
			}
			int totalsum=0;
			totalsum+=kruskal(result1)+kruskal(result2);
			result=Math.min(result, totalsum);
		}
			return;
		}
		if(arr.length==n) return;
		result1[c]=arr[n];
		combi(n+1,c+1);
		combi(n+1,c);
	}
	
	private static int kruskal(int[] result) {
		// TODO Auto-generated method stub
		li1=new ArrayList<>();
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < map[result[i]].size(); j++) {
				li1.add(new info(result[i], map[result[i]].get(j).to, map[result[i]].get(j).cost));
				
			}
		}
		Collections.sort(li1);
		int sum=0;
		for (int i = 0; i < li1.size(); i++) {
			int p1=findParents(li1.get(i).from);
			int p2=findParents(li1.get(i).to);
			if(p1!=p2) {
				union(p1,p2);
				sum+=li1.get(i).cost;
			}
		}
		return sum;
	}
	
	private static void union(int px, int py) {
		// TODO Auto-generated method stub
		parents[px]=py;
	}
	private static int findParents(int x) {
		// TODO Auto-generated method stub
		if(parents[x]==x) return x;
		return parents[x]=findParents(parents[x]);
	}
	private static boolean reachable(int[] me, int[] you) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<Integer>();
		boolean[] visited=new boolean[N+1]; 
		//다른 마을은 못 지나가게 막아둬
		for (int i = 0; i < you.length; i++) {
			visited[you[i]]=true;
		}
		for (int i = 0; i < map[me[0]].size(); i++) {
			q.add(map[me[0]].get(i).to);
		}
		while(!q.isEmpty()) {
			int start=q.poll();
			for (int i = 0; i <map[start].size(); i++) {
				//방문 가능하면(다른 마을도 아니고, 내 마을이지만 아직 방문 안 한 경우)
				if(!visited[i]) {
					visited[i]=true;
					q.add(i);
				}
			}
		}
		boolean chk=true;
		//내 마을이지만 하나라도 방문 안 햇다면 해당 마을은 연결 안 되는거야!
		for (int i = 0; i < me.length; i++) {
			if(visited[me[i]]==false) {
				chk=false;
				break;
			}
		}
		return chk;
	}
}