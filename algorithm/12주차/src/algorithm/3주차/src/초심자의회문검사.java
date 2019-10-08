import java.util.Scanner;

public class 초심자의회문검사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int TC=0;
		Scanner sc=new Scanner(System.in);
		TC=sc.nextInt();
		char[] cArr=new char[11];
		for(int tc=1;tc<=TC;tc++) {
			String str=sc.next();
			int sz=str.length();
			cArr=str.toCharArray();
			boolean chk=true;
			for(int i=0;i<(sz+1)/2;i++) {
				if(cArr[i]!=cArr[sz-1-i]) chk=false;
			}
			System.out.print("#"+tc+" ");
			if(chk) System.out.println("1");
			else System.out.println("0");
		}//tc
	}

}
