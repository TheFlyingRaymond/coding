func change(target int, coins []int) int {
	n := len(coins)
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, target+1)
		dp[i][0] = 1
	}

	for i := 1; i <= n; i++ {
		for j := 1; j <= target; j++ {
			dp[i][j] = dp[i-1][j]
			if j >= coins[i-1] {
				dp[i][j] += dp[i][j-coins[i-1]]
			}
		}
	}
	return dp[n][target]
}