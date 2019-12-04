import java.util.Scanner;
import java.util.Vector;

public class 쇠막대기자르기 {
	static int TC;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			String str=sc.next();
			
			int stick=0;
			int resul=0;
			for(int i=0;i<str.length();i++) {
				char c=str.charAt(i);
				//막대기가 시작되면 시작된 막대기수를 하나 증가.
				//막대기가 종료되면 시작된 막대기수를 하나 감소
				//레이저 떨어지면 시작된 막대기만큼을 정답에 합
				//막대기가 종료되면 정답에 +1
				if(c=='(') {
					char next=str.charAt(i+1);
					if(next=='(') {
						//막대기 시작
						stick++;
					}
				}
				else if(c==')') {
					char pre=str.charAt(i-1);
					if(pre=='(') {
						//i위치에서 레이저떨어짐
						resul+=stick;
					}else if(pre==')') {
						//i위치에 막대기 끝남
						stick--;
						resul++;
					}
				}
			}
			System.out.println("#"+tc+" "+resul);
		}//tc
	}

}
