func rob(nums []int) int {
	n := len(nums)
	if n == 1 {
		return nums[0]
	}

	return max(do_rob(nums, 0, n-2), do_rob(nums, 1, n-1))
}

func do_rob(nums []int, start int, end int) int {
	n := end - start + 1
	if n == 1 {
		return nums[start]
	}

	dp := make([]int, n+1)
	dp[1] = nums[start]

	for i := 2; i <= n; i++ {
		dp[i] = max(dp[i-1], dp[i-2]+nums[i-1+start])
	}
	return dp[n]
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}