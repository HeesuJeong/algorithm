import java.util.Random;

public class practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				//상,우,하,좌
		int[] dx= {-1,0,1,0};
		int[] dy= {0,1,0,-1};
		
		//int[][] arr=new int[5][5];
		Random r =new Random();
		
		int[][] arr= {{1,0,0,0,2},{1,0,2,0,0},{0,0,1,1,1},{0,0,1,1,1},{1,1,1,1,1}};
		
		/*for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j]=r.nextInt(20);
			}
		}*/
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("=======================");
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k <4; k++) {
					int nx=i+dx[k];
					int ny=j+dy[k];
					if(nx<0||nx>=5||ny<0||ny>=5) continue;
					sum+=Math.abs(arr[nx][ny]-arr[i][j]);
				}
			}
		}
		System.out.println("답은 : "+sum);
		
	}

}
