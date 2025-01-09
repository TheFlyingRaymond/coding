func stoneGameII(piles []int) int {
	sum := 0
	for _, v := range piles {
		sum += v
	}

	memo := make([][]*int, len(piles))

	for i := range memo {
		memeo[i] = make([]*int, 2*len(piles))
	}

	return dfs(piles, 0, 1, memeo, sum)
}

func dfs(piles []int, start int, m int, memo [][]*int, sum int) int {
	if start >= len(piles) {
		return 0
	}

	if memeo[start][m] != nil {
		return memeo[start][m]
	}

	ans, tmp := 0, 0

	for i := 1; i <= 2*m; i++ {
		tmp += piles[start+i-1]
		ans = max(ans, sum-(dfs(start+i, max(m, i), piles, memo, sum-tmp)))
	}
	memo[start][M] = &ans
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}