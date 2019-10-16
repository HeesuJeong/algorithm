package 수요일;

//다익스트라(유향그래프이다)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class 최단경로 {
	static int V;
	static int E;
	static class info{
		int vertex;
		int weight;
		public info(int vertex,int weight) {
			// TODO Auto-generated constructor stub
			this.vertex=vertex;
			this.weight=weight;
		}
	}
	static ArrayList<info>[] adj;
	static boolean[] visited;
	static int[] minArr;
	static int start;
	static PriorityQueue<info> pq;
	static final int INF=987564321;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		start=Integer.parseInt(br.readLine());
		
		adj=new ArrayList[V+1];
		for (int i = 0; i < adj.length; i++) {
			adj[i]=new ArrayList<>();
		}
		visited=new boolean[V+1];
		pq=new PriorityQueue<>(new Comparator<info>() {

			@Override
			public int compare(info o1, info o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.weight, o2.weight);
			}
		});
		minArr=new int[V+1];
		
		for (int i = 0; i <E; i++) {
			st=new StringTokenizer(br.readLine());
			int v1=Integer.parseInt(st.nextToken());
			int v2=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			adj[v1].add(new info(v2,weight)); //인접리스트 만들어주기
			//한 정점과 연결된 정점들을 나중에 가중치로 정렬해야한다.
		}
		
		Arrays.fill(minArr, INF);
		
		//자기 자신의 거리는 0으로
		minArr[start]=0;
		boolean[] visited = new boolean[V+1];
		pq.add(new info(start,minArr[start])); //시작정점 pq에 넣기
		while(!pq.isEmpty()) {
			//가중치 가장 작은 정점과 가중치 쌍을 poll한다.
			//기준정점이 삭제된 이후의 큐는 방문하지 않은 정점 중 가중치 가장 작은 정점 poll한다
		/*	System.out.println("for 밖이다!! pq출력");
			Iterator<info> it=pq.iterator();
			while(it.hasNext()) {
				info sysout=it.next();
				System.out.println(sysout.vertex+" "+sysout.weight);
			}
			System.out.println();*/
			
			info tmp=pq.poll();
			int vertex=tmp.vertex;
			int weight=tmp.weight;
			
			if(minArr[vertex] < weight)
				continue;
			/*System.out.println("tmp의 리스트 뽑아보자");
			for (int i = 0; i <adj[vertex].size(); i++) {
				System.out.println(adj[vertex].get(i).vertex+" "+adj[vertex].get(i).weight);
			}
			System.out.println();*/
			//우선순위 큐에서 삭제한 정점의 인접한 정점들을 구한다.
			for (int i = 0; i <adj[vertex].size(); i++) {
				int vTmp=adj[vertex].get(i).vertex;
				int wTmp=adj[vertex].get(i).weight;
				//System.out.println("왜ㅐㅐㅐ"+vTmp+" "+wTmp);
				//거리 무한대이거나 이전 갱신 거리보다 현 방문 거리가 작다면 거리 갱신
				if(minArr[vTmp]>minArr[vertex]+wTmp) {
					minArr[vTmp]=minArr[vertex]+wTmp;
				
					//System.out.println(Arrays.toString(minArr));
					pq.add(new info(vTmp,wTmp+weight));
					
					/*System.out.println("for문 안에서 pq출력");
					Iterator<info> it2=pq.iterator();
					while(it2.hasNext()) {
						info sysout=it2.next();
						System.out.println(sysout.vertex+" "+sysout.weight);
					}
					System.out.println();*/
				}
			}
		}
		for (int i = 1; i <V+1; i++) {
			if(minArr[i]!=INF) System.out.println(minArr[i]);
			else System.out.println("INF");
		}
	}

}
