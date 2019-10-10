package 목요일;

import java.util.Arrays;
import java.util.Scanner;

public class 키순서 {

	static int N;
	static int M;
	static int[][] map;
	static int[] up;
	static int[] down;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			int result=0;
			N=sc.nextInt();
			M=sc.nextInt();
			map=new int[N+1][N+1];
			up=new int[N+1];
			down =new int[N+1];
			for (int i = 0; i < map.length; i++) {
				Arrays.fill(map[i],999);
			}
			
			for (int i = 0; i <M; i++) {
			int go=sc.nextInt();
			int to=sc.nextInt();
			map[go][to]=1;
			}
			
			for (int i = 1; i <=N; i++) {
				//i를 걸쳐가보쟈
				for (int j = 1; j <=N; j++) {
					for (int k = 1; k <=N; k++) {
						if(i==j||j==k||i==k) continue;
						if(map[j][i]+map[i][k]<map[j][k]) {
							//System.out.println(i+"일때"+j+","+k+"위치를"+(map[j][i]+map[i][k])+"로 갱신");
							map[j][k]=map[j][i]+map[i][k];
						}
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {

					if (i == j) continue;
					if (map[i][j] != 999) {
						up[i]++;
						down[j]++;
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				if (up[i] + down[i] == N - 1) result++;
			}
			System.out.println("#"+tc+" "+result);
		}//tc
	}

}
