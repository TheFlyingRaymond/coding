func findMaxForm(strs []string, m int, n int) int {
	dp := make([][]int, m+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}

	for _, cur := range strs {
		cnt0, cnt1 := 0, 0
		for _, ch := range cur {
			if ch == '0' {
				cnt0++
			} else {
				cnt1++
			}
		}

		for i := m; i >= cnt0; i-- {
			for j := n; j >= cnt1; j-- {
				dp[i][j] = max(dp[i][j], dp[i-cnt0][j-cnt1]+1)
			}
		}
	}

	return dp[m][n]
}

// max 返回两个整数中的最大值
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}