import java.util.Scanner;

//원재의 메모리 복구하기
public class _1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		
		for(int i=1;i<=TC;i++) {
			int CNT=0;
			//본 데이터 입력받기
			String origin=sc.next();
			//System.out.println(origin.length());
			
			//비교할 값 초기화
			char[] tmp=new char[51];
			for (int j = 0; j < origin.length(); j++) {
				tmp[j]='0';
			}
			
			for (int j = 0; j < origin.length(); j++) {
				if(origin.charAt(j)!=tmp[j]) {
					CNT++;
					for (int k = j; k < origin.length(); k++) {
						tmp[k]=origin.charAt(j);
					}
					
//					for(int k2=0;k2<origin.length();k2++)
//						System.out.print(tmp[k2]);
//					System.out.println();
				}
			}
			
			System.out.println("#"+i+" "+CNT);
			
		}//TC for
		
		
		
	}//class

}
