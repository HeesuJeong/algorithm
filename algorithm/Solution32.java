package project;

import java.util.Scanner;

public class Solution32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		int[][] arr=new int[21][21];
		
		int[] dx= {0,0,1,0,-1};
		int[] dy= {0,1,0,-1,0};
		int[][] info=new int[4][6];
		for(int i=1;i<=TC;i++) {
			int Y=sc.nextInt();
			int X=sc.nextInt();
			int N=sc.nextInt();
			for(int j=1;j<=Y;j++) {
				for(int k=1;k<=X;k++) {
					arr[j][k]=sc.nextInt();
				}
			}
			//참가자들 수
			for(int j=0;j<N;j++) {
				info[0][j]=sc.nextInt();
				info[1][j]=sc.nextInt();
				info[2][j]=sc.nextInt();
				info[3][j]=-1000;
			}
			int trapNum=sc.nextInt();
			int x=0;
			int y=0;
			for(int j=0;j<trapNum;j++) {
				x=sc.nextInt();
				y=sc.nextInt();
				arr[x][y]=0;
			}
			/////////////게임 시작///////////////////
			int all_money=0;
			for(int j=0;j<N;j++) {
				int nx=info[0][j];
				int ny=info[1][j];
				int chance=info[2][j];
				for(int k=0;k<chance;k++) {
					int dir=arr[nx][ny]/10;
					int jmpCNT=arr[nx][ny]%10;
					nx+=dx[dir]*jmpCNT;
					ny+=dy[dir]*jmpCNT;
					if(nx<=0||nx>Y||ny<=0||ny>X||arr[nx][ny]==0) {
						info[3][j]=-1000;
						break;
					}
				}
				info[3][j]+=arr[nx][ny]*100;
			}//모든 사람들 게임 끝
			
			for(int j=0;j<N;j++) {
				//System.out.println("");
				all_money+=info[3][j];
			}
			
			System.out.println("#"+i+" "+all_money);
		}//TC끝
	}

}
