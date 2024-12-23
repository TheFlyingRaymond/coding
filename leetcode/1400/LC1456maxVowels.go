func maxVowels(s string, k int) int {
	if len(s) == 0 {
		return 0
	}

	cnt, max := 0, 0
	left, right := 0, min(k-1, len(s)-1)

	for i := left; i <= right; i++ {
		if isVowel(s[i]) {
			cnt++
			max = maxInt(max, cnt)
		}
	}

	for right+1 < len(s) {
		right++
		if isVowel(s[right]) {
			cnt++
		}
		if isVowel(s[left]) {
			cnt--
		}
		left++
		max = maxInt(max, cnt)
	}

	return max
}

func isVowel(c byte) bool {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}
