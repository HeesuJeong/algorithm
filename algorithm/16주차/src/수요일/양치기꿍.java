package 수요일;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 양치기꿍 {

	//늑대를 양 있는 울타리에 넣어 잡아먹게 해
	//양>늑대   늑대가 모두 잡아먹힌다.
	//양<=늑대  양이 모두 잡아먹혀
	//빈공간 '.' 울타리 '#' 늑대 'v' 양 'k'
	//결과: 살아남는 양과 늑대 수 순서대로 출력
	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;
	static int totalWolf;
	static int totalSheep;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new char[R][C];
		visited=new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str=br.readLine();
			for (int j = 0; j <C; j++) {
				char input=str.charAt(j);
				map[i][j]=input;
				if(input=='v') totalWolf++;
				else if(input=='k') totalSheep++;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j <C; j++) {
				if(visited[i][j]==false&&map[i][j]!='#') {
					sheep=0;
					wolf=0;
					visited[i][j]=true;
					BFS(i,j);
					//System.out.println(i+" "+j+"에서 양:" +sheep+" 늑대:"+wolf);
					if(sheep>wolf) totalWolf-=wolf;
					else totalSheep-=sheep;
				}
			}
		}
		//System.out.println("시작"+totalSheep+" "+totalWolf);
		System.out.println(totalSheep+" "+totalWolf);
	}
	static int sheep;
	static int wolf;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static boolean inMap(int x, int y) {
		return x>=0&&x<R&&y>=0&&y<C;
	}
	private static void BFS(int x, int y) {
		// TODO Auto-generated method stub
		Queue<Point> q= new LinkedList<Point>();
		q.add(new Point(x,y));
		//울타리 안에 하나 있는 경우 자기 자신도 카운트 해야 한다.
		if(map[x][y]=='v') wolf++;
		else if(map[x][y]=='k') sheep++;
		
		while(!q.isEmpty()) {
			Point np=q.poll();
			for (int i = 0; i <4; i++) {
				int nx=np.x+dx[i];
				int ny=np.y+dy[i];
				//****#을 빼고 나머지 영역을 BFS하면 알아서 울타리 안 영역이 탐색된다
				if(inMap(nx, ny)&&visited[nx][ny]==false&&map[nx][ny]!='#') {
					visited[nx][ny]=true;
					if(map[nx][ny]=='v') wolf++;
					else if(map[nx][ny]=='k') sheep++;
					q.add(new Point(nx,ny));
				}
			}
		}
	}

}
