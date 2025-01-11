func winnerSquareGame(n int) bool {
	memo := make([]bool, n+1)
	memo[1] = true
	return dfs(n, memo)
}

func dfs(n int, memo []bool) bool {
	if n == 0 {
		return false
	}
	if memo[n] {
		return true
	}

	for i := 1; i*i <= n; i++ {
		if !dfs(n-i*i, memo) {
			memo[n] = true
			break
		}
	}
	return memo[n]
}
