func coinChange(coins []int, amount int) int {
	n := len(coins)
	dp := make([][]int, n+1)
	no := amount + 1
	for i := range dp {
		dp[i] = make([]int, amount+1)
		for j := range dp[i] {
			dp[i][j] = no
		}
		dp[i][0] = 0
	}

	for i := 1; i <= n; i++ {
		for j := 0; j <= amount; j++ {
			coin := coins[i-1]
			dp[i][j] = dp[i-1][j]
			if j >= coin {
				// dp[i][j] = min(dp[i][j],dp[i-1][j - coin]+1)
				dp[i][j] = min(dp[i][j], dp[i][j-coin]+1)
			}
		}
	}
	if dp[n][amount] > amount {
		return -1
	}
	return dp[n][amount]
}
