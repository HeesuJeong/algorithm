//최빈수 구하기
import java.util.Scanner;

public class _1204 {

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        Scanner sc=new Scanner(System.in);
	        int TC=sc.nextInt();
	         
	         
	         
	        for (int i = 1; i <=TC; i++) {
	            int tmp=0;
	            int maxNum=0;
	            int resul=0;
	            int[] score=new int[101];
	            int num=sc.nextInt();
	             
	            for(int j=0;j<1000;j++) {
	                tmp=sc.nextInt();
	                score[tmp]++;
	            }
	            for(int j=0;j<=100;j++) {
	                if(maxNum<=score[j]) {
	                    maxNum=score[j];
	                    resul=j;
	                }
	            }
	            System.out.printf("#%d %d\n",num,resul);
	        }//TC 끝
	         
	         
	    }//class

}
