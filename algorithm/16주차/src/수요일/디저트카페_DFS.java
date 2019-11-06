package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 디저트카페_DFS {

	static int N;
	static int[] dx= {1,1,-1,-1};
	static int[] dy= {1,-1,-1,1};
	static boolean inMap(int x,int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	static int[][] map;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			visited=new boolean[101]; //디저트 종류는 1이상 100이하
			for (int i = 0; i < N; i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for (int j = 0; j <N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j <N-1; j++) {
					startX=i;
					startY=j;
					DFS(i,j,0,1);
				}
			}
		}//tc
	}
	static int startX;
	static int startY;
	static int result;
	private static void DFS(int x, int y, int dir, int cnt) {
		// TODO Auto-generated method stub
		if(cnt==4&&startX==x&&startY==y) {
			//result=Math.max(result, cnt)
			return;
		}
		for (int i = 0; i <2; i++) {
			int nx=x+dx[dir+i];
			int ny=y+dy[dir+i];
			if(inMap(nx, ny)&&visited[map[nx][ny]]==false) {
				visited[map[nx][ny]]=true;
				DFS(nx,ny,dir+i,cnt+1);
			}
		}
	}

}
