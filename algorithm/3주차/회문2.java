import java.util.Scanner;

public class 회문2 {
	static int MAX = 100;
	static char[][] arr = new char[MAX][MAX];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			// 입력부분_문자 하나씩 입력 안 되기 때문에
			for (int i = 0; i < MAX; i++) {
				arr[i]=sc.next().toCharArray();
			}
			
			int max=0;
			for(int s=0;s<100;s++) {
				for(int e=99;e>s+max-1;e--) {
					int len=e-s+1;
					int half=len/2;
					for (int i = 0; i < MAX; i++) {
						boolean flag=true;
						for (int j = 0; j < half; j++) {
							if(arr[i][s+j]!=arr[i][e-j]) {
								flag=false;
								break;
							}
						}
						if(!flag) continue;
						if(len>max) max=len;
					}
					for(int i=0;i<MAX;i++) {
						boolean flag=true;
						for(int j=0;j<half;j++) {
							if(arr[s+j][i]!=arr[e-j][i]) {
								flag=false;
								break;
							}
						}
						if(!flag) continue;
						if(len>max) max=len;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		} // tc
	}

}
