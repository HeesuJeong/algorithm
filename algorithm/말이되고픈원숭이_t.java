package 월요일;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 말이되고픈원숭이_t {

	static int K;
	static int W,H;
	static boolean[][][] visited;//[0][0][2] 2번 말처럼 뛰고 0,0 방문했다.
	static int[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		K=sc.nextInt();
		W=sc.nextInt();
		H=sc.nextInt();
		visited=new boolean[H][W][K+1];
		map=new int[H][W];
		for (int i = 0; i <H; i++) {
			for (int j = 0; j <W; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		Queue<Node> queue=new LinkedList<Node>();
		queue.add(new Node(0, 0, 0, 0));
		visited[0][0][0]=true;
		while(!queue.isEmpty()) {
			Node n=queue.poll();
			//bfs이므로 여기 들어온게 무조건 1등이다.
			if(n.r==H-1&&n.c==W-1) {
				System.out.println(n.cnt);
				return;
			}
			for (int i = 0; i <(n.k==K?4:12); i++) {
				//말처럼 뛴 횟수가 K만큼 커졋다면 4까지만 돌아야해
				//방향이 4이상인경우는 말처럼 뛰것이므로 다음 K값을 현재 K보다 1증가 시킨다.
				int nr=n.r+dr[i];
				int nc=n.c+dc[i];
				int nk=i>=4?n.k+1:n.k;
				if(nr<0||nc<0||nr>=H||nc>=W) continue;
				//장애물 위치이거나 같은 말처럼 뛴 횟수가 방문 되어있다면
				if(map[nr][nc]==1||visited[nr][nc][nk]) continue;
				visited[nr][nc][nk]=true;
				queue.add(new Node(nr, nc, nk, n.cnt+1));
			}
		}
		System.out.println("-1");
	}
	//BFS로 문제 풀거야
	//탐색하고자 하는 상태공간트리에는 x,y,말처럼 몇 번 뛰었는지,몇번 뛰어왔는지
	static class Node{
		int r,c,k,cnt;

		public Node(int r, int c, int k, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		} 
	}
	static int[] dr= {-1,1,0,0,-1,-1,1,1,-2,-2,2,2};
	static int[] dc= {0,0,-1,1,-2,2,-2,2,-1,1,-1,1};
}
