//소금쟁이 합계
package project;

import java.util.Scanner;

/*소금쟁이들의 시작주소와 방향이 주어진다
처음 3칸 두번째 2칸 세번째 1칸 뛴다
소금쟁이가 연못 밖으로 나가거나, 앞에 뛰었던 소금쟁이가 다 뛰고 머무른 위치 => 죽어
상1 하2 좌3 우4
*/
public class Solution22 {

	public static void main(String[] args) {
		
		int[] dx= {0,-1,1,0,0}; //인덱스 1부터 상하좌우
		int[] dy= {0,0,0,-1,1};
		//N이 최대 20
		boolean[][] arr=new boolean[21][21];
		
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int TC=sc.nextInt();
		for(int i=1;i<=TC;i++) {
			int N=sc.nextInt();
			int bugsNum=sc.nextInt();
			
			//살아있는 소금쟁이 수 세기 위해
			int resul=bugsNum;
			//소금쟁이 시작위치와 방향 입력받아
			for(int j=0;j<bugsNum;j++) {
				int n_x=sc.nextInt();
				int n_y=sc.nextInt();
				int dir=sc.nextInt();
				//System.out.println(n_x+" "+n_y+" "+dir);
				n_x+=(dx[dir]*6);
				n_y+=(dy[dir]*6);
				if(n_x<0||n_x>=N||n_y<0||n_y>=N||arr[n_x][n_y]==true) {
					resul--; //범위 밖이거나 다른 소금쟁이가 머문 자리
					continue;
				}
				//문제 없이 3번째까지 모두 다 뛴 소금쟁이=> 머문위치 true로 
				arr[n_x][n_y]=true;
			}
			
			System.out.println("#"+i+" "+resul);
			//초기화
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					arr[j][j2]=false;
				}
			}
		}//TC끝
	}//main 끝

}
