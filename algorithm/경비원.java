package 수요일;

import java.util.Scanner;

public class 경비원 {

	static int H;
	static int W;
	static int N;
	static int[] posi;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		H=sc.nextInt();
		W=sc.nextInt();
		N=sc.nextInt();
		posi=new int[N];
		int mePosi=0;
		for (int i = 0; i < posi.length+1; i++) {
			int tmpDir=sc.nextInt();
			int tmpWhere=sc.nextInt();
			switch (tmpDir) {
			case 1:
				tmpWhere=tmpWhere;
				break;
			case 2:		
				tmpWhere=H+W+H-tmpWhere;
				break;
			case 3:
				tmpWhere=2*H+W+(W-tmpWhere);
				break;
			case 4:
				tmpWhere=H+tmpWhere;
				break;
			}
			
			if(i==posi.length) {
				mePosi=tmpWhere;
			}
			else {
				posi[i]=tmpWhere;
			}
		}
		int result=0;
		int totalLength=2*H+2*W;
		for (int i = 0; i < posi.length; i++) {
			int tmp=posi[i];
			int a=Math.abs(mePosi-tmp);
			int b=0;
			if(tmp<mePosi)
				b=Math.abs((totalLength-mePosi)+tmp);
			else
				b=Math.abs((totalLength-tmp)+mePosi);
			if(a>b) {result+=b;}
			else {result+=a;}
		}
		System.out.println(result);
	}

}
