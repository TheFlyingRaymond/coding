func stoneGameIII(piles []int) string {
	sum := 0
	for _, v := range piles {
		sum += v
	}

	memo := make([]*int, len(piles))

	alice := dfs(piles, 0, memo, sum)
	bob := sum - alice
	if alice > bob {
		return "Alice"
	}

	if bob > alice {
		return "Bob"
	}

	return "Tie"
}

func dfs(piles []int, start int, memo []*int, sum int) int {
	if start >= len(piles) {
		return 0
	}

	if memo[start] != nil {
		return *memo[start]
	}

	ans, tmp := math.MinInt64, 0

	for i := 1; i <= 3; i++ {
		if start+i-1 >= len(piles) {
			break
		}
		tmp += piles[start+i-1]
		ans = max(ans, sum-(dfs(piles, start+i, memo, sum-tmp)))
	}
	memo[start] = &ans
	return ans
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}