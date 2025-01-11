func divisorGame(n int) bool {
	if n == 1 {
		return false
	}

	dp := make([]bool, n+1)

	for i := 1; i <= n; i++ {
		for j := 1; j < i; j++ {
			if i%j == 0 && !dp[i-j] {
				dp[i] = true
			}
		}
	}

	return dp[n]
}
