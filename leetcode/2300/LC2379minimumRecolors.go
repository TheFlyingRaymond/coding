func minimumRecolors(blocks string, k int) int {
	cnt, ret := 0, k
	left, right := 0, k

	for i := 0; i < right; i++ {
		if blocks[i] == 'W' {
			cnt++
		}
	}
	ret = min(cnt, ret)

	for right < len(blocks) {
		if blocks[right] == 'W' {
			cnt++
		}
		right++

		if blocks[left] == 'W' {
			cnt--
		}
		left++

		ret = min(cnt, ret)
	}

	return ret
}