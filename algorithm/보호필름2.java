package 금요일;

import java.util.Arrays;
import java.util.Scanner;

public class 보호필름2 {
	static int H;// 행
	static int W;
	static int K; // 합격 기준
	static int[][] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			H=sc.nextInt();
			W=sc.nextInt();
			K=sc.nextInt();
			map=new int[H][W];
			for (int i = 0; i <H; i++) {
				for (int j = 0; j <W; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			result=Integer.MAX_VALUE;
			DFS(map,0,0);
			System.out.println("#"+tc+" "+ (K==1?0:result));
		}//tc
	}
	static int result;
	//바꿀 행을 선택하는 x
	private static void DFS(int[][] map,int x, int cnt) {
		// TODO Auto-generated method stub
		//검사해보기
		/*for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("=================");*/
		if(test(map)) {
			result=Math.min(result, cnt);
		}
		if(cnt > result)
			return;
		if(x==H) {
			return;
		}
		int[] tmp = new int[W];
		for(int i = 0; i < W; i++)
			tmp[i] = map[x][i];
		DFS(map,x+1,cnt);
		Arrays.fill(map[x],0);
		DFS(map,x+1,cnt+1);
		Arrays.fill(map[x],1);
		DFS(map,x+1,cnt+1);
		for(int i = 0; i < W; i++)
			map[x][i] = tmp[i];
	}

	// 검사행렬
	static boolean test(int[][] arr) {
		boolean chk = true;
		boolean[] chkArr = new boolean[W];
		for (int j = 0; j < W; j++) { // 가로기준
			int cnt = 0;
			for (int i = 1; i < H; i++) {// 세로기준
				if (arr[i - 1][j] == arr[i][j]) {
					cnt++;
					if (cnt == K - 1) {
						chkArr[j] = true;
						break;
					}
				} else
					cnt = 0;
			}
			if(!chkArr[j])
				return false;
		}
		// 하나라도 통과 못 하는 세로줄 있으면 노패스!
		for (int i = 0; i < chkArr.length; i++) {
			if (chkArr[i] == false) {
				chk = false;
				break;
			}
		}
		return chk;
	}

}
