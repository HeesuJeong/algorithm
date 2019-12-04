package 수요일;

import java.util.Scanner;

public class 로봇청소기 {
//청소하는 영역 개수 구하기
//N*M 벽 또는 빈칸
//1. 현 위치 청소
//2. 현 방향의 왼쪽방향부터 탐색한다
	//2.a 아직 청소 안 한 공간 잇다면 => 그 방향으로 회전하고 한 칸 전진
	//2.b 청소 공간 없으면 =>그 방향으로 회전하고 + 다시 2로
	//2.c 이미 네 방향 모두 청소했거나, 모두 벽이면 => 바라보는 방향 유지하고 한칸 후진 + 2로
	//2.d 네 방향 모두 이미 청소 및 벽이고, 후진도 할 수 없는 경우에 => 작동 멈춘다
	
//청소한 칸 다시 청소하지 않아, 벽 통과 불가
	static int N;
	static int M;
	static int[][] map;
	static int[] dx= {-1,0,1,0}; //북동남서
	static int[] dy= {0,1,0,-1};
	static class info{
		int x;
		int y;
		int dir;
		public info(int x, int y, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	static info robot;
	static boolean inMap(int x,int y) {
		return x>=0&&x<N&&x>=0&&x<M;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new int[N][M];
		robot=new info(sc.nextInt(), sc.nextInt(), sc.nextInt());
		for (int i = 0; i <N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		result=0;
		DFS(robot.x,robot.y,robot.dir);
		System.out.println(result);
	}
	static int result;
	private static void DFS(int x, int y, int dir) {
		// TODO Auto-generated method stub
		if(map[x][y]==1) return;//후진 햇는데도 불가한 경우
		
		map[x][y]=1;//현 위치 청소.
		result++; //청소 영역 늘었다
		int realdir=dir;
		for (int i = 0; i < 4; i++) { //현재 방향의 왼쪽 방향을 검사(4방향 모두 검사)
			dir=dir-1==-1?3:dir-1;
			int nx=x+dx[dir];
			int ny=y+dy[dir];
			if(inMap(nx, ny)&&map[nx][ny]==0) {
				System.out.println(nx+" "+ny);
				DFS(nx, ny,dir); //해당 방향으로 바뀌고 해당 위치로!
				return; //네방향 중 한 방향으로 들어가면 나머지 방향은 더 이상 들어가지 않아
			}
		}
		//앞에서 재귀 안 탔다는 것은 4방향 모두 불가했다는 것!
		//후진한다.바라보는 방향은 유지
		if(dir==0) dir=2;
		else if(dir==1) dir=3;
		else if(dir==2) dir=0;
		else if(dir==3) dir=1;
		DFS(x+dx[dir], y+dy[dir], realdir); //후진한다.
	}

}
