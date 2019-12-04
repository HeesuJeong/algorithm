package 월요일;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 말이되고픈원숭이 {
	static int K; // 30이하
	static int[][] map;// 0평지 1장애물
	static int W;
	static int H;
	static int result; // 최소 점프 수 구하기
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] hx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] hy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static boolean inMap(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
	static int[][][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited=new int[H][W][K+1];//점프 0번해서 가는 경우, ..., 점프 K번해서 가는 경우
		result=Integer.MAX_VALUE;
		BFS(0,0);
		//System.out.println("main에서"+result);
		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}
	static class info{
		int x;
		int y;
		int horse;
		int cnt;
		public info(int x, int y, int horse, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.horse = horse;
			this.cnt = cnt;
		}
	}
	private static void BFS(int x, int y) {
		// TODO Auto-generated method stub
		Queue<info> q= new LinkedList<info>();
		q.add(new info(x, y, 0, 0));
		visited[x][y][0]=-1;//시작점 재방문 안 하기 위해
		while(!q.isEmpty()) {
			info tmp=q.poll();
			//System.out.println(tmp.x+" "+tmp.y+" 입장에서 봅니다. 말처럼 뛴 수 "+tmp.horse);
			if(tmp.x==H-1&&tmp.y==W-1) {
				//System.out.println("?");
				int min=Integer.MAX_VALUE;
				for (int i = 0; i < visited[0][0].length; i++) {
					if(visited[H-1][W-1][i]!=0&&min>visited[H-1][W-1][i]) {
						//System.out.println(visited[H-1][W-1][i]);
						min=Math.min(min, visited[H-1][W-1][i]);
					}
				}
				result=(min==Integer.MAX_VALUE?-1:min);
				//System.out.println("기저에서 "+result);
			}
			//말처럼 뛸 기회 남아있다면
			if(tmp.horse<K) {
				for (int i = 0; i < hx.length; i++) {
					int nx=tmp.x+hx[i];
					int ny=tmp.y+hy[i];
					//이전에 말처럼 뛴 횟수+1
					if(inMap(nx, ny)&&map[nx][ny]==0&&visited[nx][ny][tmp.horse+1]==0) {
						//System.out.println("말: "+nx+" "+ny+" 넣는다");
						visited[nx][ny][tmp.horse+1]=tmp.cnt+1;
						q.add(new info(nx, ny, tmp.horse+1, tmp.cnt+1));
					}
				}
			}
			//원숭이처럼 뛰어보쟈
			for (int i = 0; i < dx.length; i++) {
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				//이전에 말처럼 뛴 횟수+1
				if(inMap(nx, ny)&&map[nx][ny]==0&&visited[nx][ny][tmp.horse]==0) {
					//System.out.println("원숭이: "+nx+" "+ny+" 넣는다");
					visited[nx][ny][tmp.horse]=tmp.cnt+1;
					q.add(new info(nx, ny, tmp.horse, tmp.cnt+1));
				}
			}
		}
	}

}
