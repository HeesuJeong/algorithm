import java.util.Scanner;

public class _1210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=10;
		
		for (int tc = 1; tc <= T; tc++) {
			sc.nextInt();
			
			int[][] map=new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			//사다리 맵의 맨 마지막줄 첫칸부터 끝칸까지 탐색하며, 1이나 2 있는 위치 찾자.
			int[] lanes =new int[100];
			int idx=0;
			int col=0;
			for (int i = 0; i < 100; i++) {
				if(map[99][i]==1) {
					lanes[idx++]=i;
				}
				else if(map[99][i]==2) {
					col=idx;
					lanes[idx++]=i;
				}
			}//for i
			
			int row=99;
			//row가 맨 위에 닿을 때까지
			while(row>0) {
				if(col>0&&map[row][lanes[col]-1]==1) { col--;}
				else if(col<idx-1&&map[row][lanes[col]+1]==1) {col++;}
				row--;
			}
			System.out.println("#"+tc+" "+lanes[col]);
			
		}//TC
	}

}
