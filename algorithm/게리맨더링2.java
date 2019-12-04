package 수요일;

import java.util.Arrays;
import java.util.Scanner;

public class 게리맨더링2 {
	static int[][] map;
	static int[][] divide;
	static int N;
	static int[] dx= {1,1};
	static int[] dy= {-1,1}; //왼쪽 아래, 오른쪽 아래
	static int result;
	static int[][] info;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		result=Integer.MAX_VALUE;
		for (int i = 0; i <N-2; i++) {
			for (int j = 1; j <N-1; j++) {
				choice(i,j);
			}
		}
		System.out.println(result);
	}
	private static void choice(int x, int y) {
		int left=y;//왼쪽으로 갈 수 있는 최대치
		int right=N-1-y;//오른쪽으로 갈 수 있는 최대치
		for (int i = 1; i <=left; i++) {
			for (int j = 1; j <=right; j++) {
				make(x,y,i,j);
			}
		}
	}
	private static void make(int x, int y, int left, int right) {
		// TODO Auto-generated method stub
		if(x+left+right>=N) return;//범위 벗어나서 마름모 그릴 수 없는 경우
		divide=new int[N][N];
		info=new int[4][2];
		info[0][0]=x; info[0][1]=y; //마름모 맨 위
		info[1][0]=x+left; info[1][1]=y-right; //마름모 왼쪽 점
		info[2][0]=x+right; info[2][1]=y+right; //마름모 오른쪽 점
		info[3][0]=x+left+right; info[3][1]=y-left+right; //마름모 아래 점
		
		//5번 경계선 만들기
		divide[x][y]=5;
		//왼쪽 상부 경계
		for (int i = 1; i <=left; i++) {
			divide[x+dx[0]*i][y+dy[0]*i]=5;
		}
		//오른쪽 상부 경계
		for (int i = 1; i <=right; i++) {
			divide[x+dx[1]*i][y+dy[1]*i]=5;
		}
		int xx=x+left;//왼쪽점 기준두기
		int yy=y-left;
		//왼쪽 하부 
		for (int i = 1; i <=right; i++) {
			divide[xx+dx[1]*i][yy+dy[1]*i]=5;
		}
		xx=x+right;
		yy=y+right;
		//오른쪽 하부
		for (int i = 1; i <=left; i++) {
			divide[xx+dx[0]*i][yy+dy[0]*i]=5;
		}
		
		//1번 구역 채우기
		for (int i = 0; i < info[1][0]; i++) {
			for (int j = 0; j <=info[0][1]; j++) {
				if(divide[i][j]==5) break;
				divide[i][j]=1;
			}
		}
		//2번 구역 채우기
		for (int i = 0; i <=info[2][0]; i++) {
			for (int j = N-1; j >info[0][1]; j--) {
				if(divide[i][j]==5) break;
				divide[i][j]=2;
			}
		}
		//3번 구역 채우기
		for (int i = info[1][0]; i < N; i++) {
			for (int j = 0; j <info[3][1]; j++) {
				if(divide[i][j]==5) break;
				divide[i][j]=3;
			}
		}
		//4번 구역 채우기
		for (int i = info[2][0]+1; i < N; i++) {
			for (int j = N-1; j >=info[3][1]; j--) {
				if(divide[i][j]==5) break;
				divide[i][j]=4;
			}
		}
		//각 선거구 인구 합 구하기
		int[] sumArr=new int[5];
		for (int i = 0; i <N; i++) {
			for (int j = 0; j <N; j++) {
				if(divide[i][j]==0) sumArr[4]+=map[i][j];
				else sumArr[divide[i][j]-1]+=map[i][j];
			}
		}
		Arrays.sort(sumArr);
		int min=sumArr[0];//최소
		int max=sumArr[4];//최대
		//System.out.println(x+" "+y+"에서 최대-최소 값은: "+(max-min));
		result=Math.min(result, max-min);
	}

}
