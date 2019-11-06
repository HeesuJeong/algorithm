import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이 {

	static int K;
	static int W;//가로
	static int H;//세로
	static int result=Integer.MAX_VALUE;
	//4이상부터는 말의 움직임
	static int[] dx= {-1,1,0,0,-2,-1,1,2,2,1,-1,-2};
	static int[] dy= {0,0,-1,1,1,2,2,1,-1,-2,-2,-1};
	/*static int[] jmpX= {-2,-1,1,2,2,1,-1,-2};
	static int[] jmpY= {1,2,2,1,-1,-2,-2,-1};*/
	static boolean inMap(int x,int y) {
		return x>=0&&x<H&&y>=0&&y<W;
	}
	static int[][] map;
	static boolean[][][] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		K=sc.nextInt();
		W=sc.nextInt();
		H=sc.nextInt();
		map=new int[H][W];
		visited=new boolean[H][W][31];
		for (int i = 0; i <H; i++) {
			for (int j = 0; j < W; j++) {
				int input=sc.nextInt();
				map[i][j]=input;
			}
		}
		
		BFS(0,0);
		if(result==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(result);
	}
	static class info{
		int x;
		int y;
		int jmp;
		int cnt;
		public info(int x,int y,int jmp,int cnt) {
			// TODO Auto-generated constructor stub
			this.x=x;
			this.y=y;
			this.jmp=jmp;
			this.cnt=cnt;
		}
	}
	private static void BFS(int x, int y) {
		// TODO Auto-generated method stub
		Queue<info> q=new LinkedList<info>();
		q.add(new info(x,y,0,0));
		visited[x][y][0]=true;
		while(!q.isEmpty()) {
			info tmp=q.poll();
			if(tmp.x==H-1&&tmp.y==W-1) {
				result=Math.max(result, tmp.cnt);
			}
			for (int i = 0; i < dx.length; i++) {
				int nx=tmp.x+dx[i];
				int ny=tmp.y+dy[i];
				int njmp=tmp.jmp;
				int ncnt=tmp.cnt;
				boolean canJmp=false;
				if(njmp<K) canJmp=true;
				if(inMap(nx, ny)&&visited[nx][ny][ncnt+1]==false) {
					if(i<4) {		
						visited[nx][ny][ncnt+1]=true;
						q.add(new info(nx, ny, tmp.jmp, tmp.cnt+1));
					}else if(i>=4&&canJmp){
						visited[nx][ny][ncnt+1]=true;
						q.add(new info(nx,ny,tmp.jmp+1,tmp.cnt+1));
					}
				}
			}
		}
	}

}
