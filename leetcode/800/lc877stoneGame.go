func stoneGame(piles []int) bool {
	n := len(piles)
	dp := make([]int, n+1)
	dp[0] = 0
	dp[1] = piles[0]

	sum := dp[1]
	for i := 2; i <= n; i++ {
		cur := piles[i-1]
		sum += cur
		dp[i] = max(dp[i-1], sum-dp[i-1])
	}

	return sum-dp[n] < dp[n]
}