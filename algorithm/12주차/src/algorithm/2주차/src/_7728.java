import java.util.Scanner;

public class _7728 {
	static int TC;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		TC=sc.nextInt();
	
		for (int tc = 1; tc <=TC; tc++) {
			String cArr="";
			boolean chkArr[]=new boolean[10];
			
			int input=sc.nextInt();
			cArr=Integer.toString(input);
			for (int i = 0; i < cArr.length(); i++) {
				chkArr[cArr.charAt(i)-'0']=true;
			}
			int cnt=0;
			for (int i = 0; i < chkArr.length; i++) {
				if(chkArr[i]==true) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}
	}

}
