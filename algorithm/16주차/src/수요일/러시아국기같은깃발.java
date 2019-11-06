package 수요일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 러시아국기같은깃발 {

	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			int result = 0;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char tmp = str.charAt(j);
					map[i][j] = tmp;
					if ((i == 0 && tmp != 'W') || (i == N - 1 && tmp != 'R'))
						result++;
				}
			}
			//System.out.println("첫줄 마지막줄 "+result);
			//System.out.println(result);
			int tmp=N*M;
			// 두번째줄부터 N-2번째줄 확인하기
			for (int i = 0; i <= N - 3; i++) {// 흰색 내려와
				for (int j = 0; j <= N - 3; j++) {// 빨강 올라와
					// 나머지가 파랑영역
					if(N-2-(i+j)<=0) continue;
					int cnt = 0;
					int w=0;
					int b=0;
					int red=0;
					for (int r = 0; r < i; r++) {
						for (int k = 0; k < M; k++) {
							if (map[1 + r][k] != 'W')
								w++;
						}
					}
					for (int r = 1 + i; r < N - 1 - j; r++) {
						for (int k = 0; k < M; k++) {
							if (map[r][k] != 'B')
								b++;
						}
					}
					for (int r=0;r<j;r++) {
						for (int k = 0; k <M; k++) {
							if(map[N-2-r][k]!='R') red++;
						}
					}
					cnt=w+b+red;
					//System.out.println("흰색 : "+i+" 빨강: "+j);
				//System.out.println("흰색: "+w+"파랑: "+b+"빨강: "+red+" 일때 cnt "+cnt);
					tmp=Math.min(cnt, tmp);
				}
			}
			//System.out.println("tmp? "+tmp);
			System.out.println("#"+tc+" "+(result+tmp));
		} // tc
	}

}
