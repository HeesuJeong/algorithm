package 수요일;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 페그솔리티어 {
	static final int H=5;
	static final int W=9;
	static char[][] map;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		map=new char[H][W];
		String str="";
		for (int tc = 1; tc <=TC; tc++) {
			for (int i = 0; i < H; i++) {
				str=sc.next();
				for (int j = 0; j <W; j++) {
					map[i][j]=str.charAt(j);
				}
			}
			resultFirst=Integer.MAX_VALUE;
			resultSecond=Integer.MAX_VALUE;
			li=new ArrayList<>();
			func(0);
			Collections.sort(li);
			System.out.println(li.get(0).first+" "+li.get(0).second);
		}//tc
	}
	
	static int resultFirst;
	static int resultSecond;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static boolean inMap(int x,int y) {
		return x>=0&&x<H&&y>=0&&y<W;
	}
	static class info implements Comparable<info>{
		int first;
		int second;
		public info(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
		@Override
		public int compareTo(info o) {
			// TODO Auto-generated method stub
			int ret=0;
			if(this.first>o.first) ret=1;
			else if(this.first<o.first) ret=-1;
			else {
				if(this.second>o.second) ret=1;
				else if(this.second<o.second) ret=-1;
				else ret=0;
			}
			return ret;
		}
		
	}
	static ArrayList<info> li;
	private static void func(int cnt) {
		int circle=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]=='o') {
					circle++;
				}
			}
		}
		circle=Math.min(circle, resultFirst);
		li.add(new info(circle, cnt));
		
		
		for (int i = 0; i <H; i++) {
			for (int j = 0; j <W; j++) {
				if(map[i][j]=='o') {
					for (int k = 0; k < dx.length; k++) {
						int nx=i+dx[k];
						int ny=j+dy[k];
						int nnx=nx+dx[k];
						int nny=ny+dy[k];
						if(inMap(nx, ny)&&inMap(nnx,nny)&&map[nx][ny]=='o'&&map[nnx][nny]=='.') {
							//정보 바꾸기
							map[i][j]='.';//내 자리 빈칸
							map[nx][ny]='.';//내 옆도 빈칸
							map[nnx][nny]='o';//자리 옮기기
							func(cnt+1);
							//백트랙킹
							map[i][j]='o';
							map[nx][ny]='o';
							map[nnx][nny]='.';
						}
					}
					
				}
			}
		} //o의 상하좌우 더이상 볼 데 없으면
		
	}

}
