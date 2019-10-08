
public class 피보나치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		System.out.println(fibo(45));
		long end=System.currentTimeMillis();
		System.out.println(end-start); //ms
	}
	static int fibo(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		
		return fibo(n-1)+fibo(n-2);
	}
}
