// func canPartition(weights []int) bool {
// 	sum := 0
// 	for _, value := range weights {
// 		sum += value
// 	}

// 	if sum%2 == 1 {
// 		return false
// 	}

// 	sum = sum / 2

// 	n := len(weights)
// 	dp := make([][]bool, n+1)
// 	for i := range dp {
// 		dp[i] = make([]bool, sum+1)
// 	}
// 	for i := 0; i <= n; i++ {
// 		dp[i][0] = true
// 	}

// 	// 填充动态规划表
// 	for i := 1; i <= n; i++ {
// 		for j := 1; j <= sum; j++ {
// 			dp[i][j] = dp[i-1][j]
// 			if j-weights[i-1] >= 0 {
// 				dp[i][j] = dp[i][j] || dp[i-1][j-weights[i-1]]
// 			}
// 		}
// 	}

// 	return dp[n][sum]
// }

func canPartition(weights []int) bool {
	sum := 0
	for _, value := range weights {
		sum += value
	}

	if sum%2 == 1 {
		return false
	}

	sum = sum / 2

	n := len(weights)
	dp := make([]bool, sum+1)
	dp[0] = true

	for i := 1; i <= n; i++ {
		for j := sum; j > 0; j-- {
			if j-weights[i-1] >= 0 {
				dp[j] = dp[j] || dp[j-weights[i-1]]
			}
		}
	}

	return dp[sum]
}