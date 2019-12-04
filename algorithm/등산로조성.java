package 금요일;

import java.util.ArrayList;
import java.util.Scanner;

public class 등산로조성 {
	static int N;
	static int K;
	static int[][] map;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static boolean inMap(int x, int y) {
		return x>=0&&x<N&&y>=0&&y<N;
	}
	static int result;
	static class info{
		int x;
		int y;
		public info(int x,int y) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
		}
	}
	static ArrayList<info> li;
	static boolean[][] visited;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			N=sc.nextInt();
			K=sc.nextInt();
			map=new int[N][N];
			li=new ArrayList<>();
			int max=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					map[i][j]=sc.nextInt();
					max=Math.max(map[i][j], max);
				}
			} 
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(max==map[i][j]) li.add(new info(i, j));
				}
			}
			result=Integer.MIN_VALUE;
			for (int i = 0; i < li.size(); i++) {
				int x=li.get(i).x;
				int y=li.get(i).y;
				visited=new boolean[N][N];
				visited[x][y]=true;
				DFS(x,y,1,1);
				visited[x][y]=false;
			}
			System.out.println("#"+tc+" "+result);
		}//tc
	}
	private static void DFS(int x, int y,int opp,int cnt) {
		// TODO Auto-generated method stub
		if(result<cnt) {
			//System.out.println("갱신:" +cnt);
			result=cnt;
		}
		for (int i = 0; i < 4; i++) {
			
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(inMap(nx, ny)&&visited[nx][ny]==false) {
				if(map[nx][ny]<map[x][y]) {
					//System.out.println("나의 위치 "+x+","+y+" 보는 위치"+nx+","+ny);
					visited[nx][ny]=true;
					DFS(nx,ny,opp,cnt+1);
					visited[nx][ny]=false;
				}else if(opp==1&&map[nx][ny]>=map[x][y]&&map[nx][ny]-K<map[x][y]){
					//나보다 더 큰 곳 이지만 한 번 깍아서 갈 수 있으면 간다.
					int tmp=map[nx][ny];
					visited[nx][ny]=true;
					map[nx][ny]=map[x][y]-1;
					DFS(nx,ny,opp-1,cnt+1);
					map[nx][ny]=tmp;
					visited[nx][ny]=false;
				}
			}
		}
	}

}
