func predictTheWinner(nums []int) bool {
	n := len(nums)
	memo := make([][]*int, n)
	for i := range memo {
		memo[i] = make([]*int, n)
		memo[i][i] = &nums[i]
	}

	return dfs(0, n-1, nums, memo) >= 0
}

func dfs(start int, end int, nums []int, memo [][]*int) int {
	if memo[start][end] != nil {
		return *memo[start][end]
	}

	v1 := nums[start] - dfs(start+1, end, nums, memo)
	v2 := nums[end] - dfs(start, end-1, nums, memo)

	result := max(v1, v2)
	memo[start][end] = &result
	return result
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}