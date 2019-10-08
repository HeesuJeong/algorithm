
import java.awt.Point;
import java.util.Scanner;

public class 상호의배틀필드 {

	static class posi{
		int nx;
		int ny;
		int lx;
		int ly;
	}
	static int T;
	static char[][] map;
	static Scanner sc=new Scanner(System.in);
	static int H;
	static int W;
	static int N;
	static String command;
	static char dir;
	
	static boolean inMap(int x,int y) {
		return x>=0&&x<H&&y>=0&&y<W;
	}
	static posi shoot(posi p) {
		int mx=p.lx;
		int my=p.ly;
		if(dir=='l') {
			while(inMap(mx, my)) {
				if(map[mx][my]=='#') break;
				if(map[mx][my]=='*') {
					map[mx][my]='.';
					break;
				}
				my--;
			}
		}
		else if(dir=='r') {
			while(inMap(mx, my)) {
				if(map[mx][my]=='#') break;
				if(map[mx][my]=='*') {
					map[mx][my]='.';
					break;
				}
				my++;
			}
		}
		else if(dir=='u') {
			while(inMap(mx, my)) {
				if(map[mx][my]=='#') break;
				if(map[mx][my]=='*') {
					map[mx][my]='.';
					break;
				}
				mx--;
			}
		}
		if(dir=='d') {
			while(inMap(mx, my)) {
				if(map[mx][my]=='#') break;
				if(map[mx][my]=='*') {
					map[mx][my]='.';
					break;
				}
				mx++;
			}
		}
		return p;
	}
	static posi left(posi p) {
		//왼쪽 바라보게 하기
		p.lx=p.nx;
		p.ly=p.ny-1;
		if(inMap(p.lx,p.ly)&&map[p.lx][p.ly]=='.') {
			map[p.nx][p.ny]='.';
			p.nx=p.lx;
			p.ny=p.ly;
			p.ly=p.ny-1;
		}
		dir='l';
		return p;
	}
	static posi right(posi p) {
		//오른쪽 바라보게 하기
		p.lx=p.nx;
		p.ly=p.ny+1;
		if(inMap(p.lx,p.ly)&&map[p.lx][p.ly]=='.') {
			map[p.nx][p.ny]='.';
			p.nx=p.lx;
			p.ny=p.ly;
			p.ly=p.ny+1;
		}
		dir='r';
		return p;
	}
	static posi up(posi p) {
		//위쪽 바라보게 하기
		p.lx=p.nx-1;
		p.ly=p.ny;
		if(inMap(p.lx,p.ly)&&map[p.lx][p.ly]=='.') {
			map[p.nx][p.ny]='.';
			p.nx=p.lx;
			p.ny=p.ly;
			p.lx=p.nx-1;
		}
		dir='u';
		return p;
	}
	static posi down(posi p) {
		//아래쪽 바라보게 하기
		p.lx=p.nx+1;
		p.ly=p.ny;
		if(inMap(p.lx,p.ly)&&map[p.lx][p.ly]=='.') {
			map[p.nx][p.ny]='.';
			p.nx=p.lx;
			p.ny=p.ly;
			p.lx=p.nx+1;
		}
		dir='d';
		return p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T=sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			H=sc.nextInt();
			W=sc.nextInt();
			map=new char[H][W];
			posi p=new posi();
			
			for (int i = 0; i < H; i++) {
				String str=sc.next();
				for (int j = 0; j < W; j++) {
					char input=str.charAt(j);
					if(input=='<'||input=='>'||input=='v'||input=='^') {
						p.nx=i;
						p.ny=j;
						if(input=='<') {
							p.lx=p.nx;
							p.ly=p.ny-1;
							dir='l';
						}else if(input=='>') {
							p.lx=p.nx;
							p.ly=p.ny+1;
							dir='r';
						}else if(input=='v') {
							p.lx=p.nx+1;
							p.ly=p.ny;
							dir='d';
						}else if(input=='^') {
							p.lx=p.nx-1;
							p.ly=p.ny;
							dir='u';
						}
					}
					map[i][j]=input;
				}
			}
			N=sc.nextInt();
			command=sc.next();
			////////////게임 시작
			for (int i = 0; i < N; i++) {
				char c=command.charAt(i);
				if(c=='S') {
					p=shoot(p);
				}else if(c=='U') {
					p=up(p);
				}else if(c=='D') {
					p=down(p);
				}else if(c=='L') {
					p=left(p);
				}else if(c=='R') {
					p=right(p);
				}
			}
			if(dir=='l') {
				map[p.nx][p.ny]='<';
			}else if(dir=='r') {
				map[p.nx][p.ny]='>';
			}else if(dir=='u') {
				map[p.nx][p.ny]='^';
			}else if(dir=='d') {
				map[p.nx][p.ny]='v';
			}
			//출력부분
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}//tc
	}

}
