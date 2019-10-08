
public class 이항계수 {

	public static void main(String[] args) {
		memo = new long[200][200];
		// TODO Auto-generated method stub
		System.out.println(bino_dp(100, 50));
	}

	//상향식 접근
	static long bino_dp(int n,int k) {
		long[][] dp=new long[n+1][k+1];
		for (int i = 1; i <=n; i++) {
			for (int j = 0; j <=k; j++) {
				//안 고르는 경우와 모두 고르는 경우는 1
				if(j==0||j==i) dp[i][j]=1;
				else if(i>0&&j>0) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		return dp[n][k];
	}
	//하향식 접근
	static long[][] memo;
	static long bino(int n, int k) {
		if (memo[n][k] != 0)
			return memo[n][k];
		if (k == 0)
			return 1;
		if (k == n)
			return 1;
		memo[n][k] = bino(n - 1, k - 1) + bino(n - 1, k);
		return memo[n][k];
	}
}
