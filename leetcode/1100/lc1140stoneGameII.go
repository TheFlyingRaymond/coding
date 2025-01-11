func stoneGameII(piles []int) int {
	n := len(piles)
	memo := make([][]int, n)
	for i := 0; i < len(memo); i++ {
		memo[i] = make([]int, 2*n)
	}

	sum := 0
	for _, v := range piles {
		sum += v
	}

	win := dfs(0, 1, piles, memo)

	return (sum + win) / 2
}

func dfs(start int, m int, piles []int, memo [][]int) int {
	if start >= len(piles) {
		return 0
	}
	if memo[start][m] != 0 {
		return memo[start][m]
	}

	sum := piles[start]
	win := sum - dfs(start+1, max(1, m), piles, memo)
	for i := 2; i <= 2*m && start+i-1 < len(piles); i++ {
		sum += piles[start+i-1]
		win = max(win, sum-dfs(start+i, max(i, m), piles, memo))
	}
	memo[start][m] = win
	return win
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
