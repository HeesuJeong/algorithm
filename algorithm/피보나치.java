
public class 피보나치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memo=new int[100];
		long start=System.currentTimeMillis();
		System.out.println(fibo(30));
		//System.out.println(fibo_dp(30));
		long end=System.currentTimeMillis();
		System.out.println(end-start);
	}
	//상향식DP_밑에서부터 쌓아올려
	static int fibo_dp(int n) {
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) dp[i]=dp[i-1]+dp[i-2];
		return dp[n];
	}
	
	//하향식DP
	static int[] memo;
	static int fibo(int n) {
		if(memo[n]!=0) return memo[n];
		if(n==0) return 0;
		if(n==1) return 1;
		
		memo[n]=fibo(n-1)+fibo(n-2);
		return memo[n];
	}

}
