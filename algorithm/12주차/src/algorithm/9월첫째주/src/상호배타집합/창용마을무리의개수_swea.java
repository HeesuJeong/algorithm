package 상호배타집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 창용마을무리의개수_swea {

	static int[] arr;
	static int N;
	static int M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			StringTokenizer nm=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(nm.nextToken()); //사람수
			int M=Integer.parseInt(nm.nextToken()); //관계수
			arr=new int[N+1]; //사람
			
			for (int i = 1; i <=N; i++) {
				arr[i]=i;
			}
			for (int i = 0; i <M; i++) {
				nm=new StringTokenizer(br.readLine());
				union(Integer.parseInt(nm.nextToken()),Integer.parseInt(nm.nextToken()));
			}
			
			int cnt=0;
			for (int i = 1; i <=N; i++) {
				if(i==arr[i]) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}//tc
	}
	static int find(int x) {
		if(x==arr[x]) return x;
		arr[x]=find(arr[x]);
		return arr[x];
	}
	static void union(int x,int y) {
		int px=find(x);
		int py=find(y);
		arr[px]=py;
	}
}
