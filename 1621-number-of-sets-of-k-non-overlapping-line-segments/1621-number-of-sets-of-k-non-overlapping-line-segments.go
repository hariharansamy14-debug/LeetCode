func numberOfSets(n int, k int) int {
	const MOD int64 = 1_000_000_007

	
	dp := make([][]int64, n)
	for i := range dp {
		dp[i] = make([]int64, k+1)
		dp[i][0] = 1 
	}

	for j := 1; j <= k; j++ {
		var sum int64 = 0
		for i := 1; i < n; i++ {
			sum = (sum + dp[i-1][j-1]) % MOD
			dp[i][j] = (dp[i-1][j] + sum) % MOD
		}
	}

	return int(dp[n-1][k])
}