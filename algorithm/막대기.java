
public class 막대기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		memo=new long[100];
		System.out.println(recur(30));
		System.out.println(recur_dp(30));
	}
	
	static long recur_dp(int x) {
		long[] dp=new long[x+1];
		dp[1]=2;
		dp[2]=5;
		for (int i = 3; i <=x; i++) {
			dp[i]=dp[i-1]*2+dp[i-2];
		}
		return dp[x];
	}
	//memorization
	static long[] memo;
	public static long recur(int x) {
		if(memo[x]!=0) return memo[x];
		if(x==1) return 2;
		if(x==2) return 5;
		memo[x]=recur(x-1)*2+recur(x-2);
		return memo[x];
	}
}
