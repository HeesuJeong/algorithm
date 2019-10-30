import java.util.Scanner;

public class 조합_t {

	static final int P=1234567891;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int TC=sc.nextInt();
		for (int tc = 1; tc <=TC; tc++) {
			int N=sc.nextInt();
			int R=sc.nextInt();
			
			long[] arr = new long[N + 1];
			arr[0] = 1;
			arr[1] = 1;
			for (int i = 2; i < arr.length; i++) {
				arr[i] = (arr[i - 1] * i) % P;
			}
			long result=arr[N]*power(arr[N-R]*arr[R]%P,P-2)%P;
			System.out.println("#"+tc+" "+result);
		}//tc
	}
	static long power(long base,int ex) {
		if(ex==1) return base;
		long result=power(base,ex/2);
		if(ex%2==0) {
			return result*result%P;
		}else return result*result%P*base%P;
	}
}
