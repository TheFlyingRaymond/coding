func hasAllCodes(s string, k int) bool {
	if len(s) < k {
		return false
	}
	left, right := 0, k
	set := make(map[string]struct{})
	set[s[left:right]] = struct{}{}

	for right < len(s) {
		right++
		left++
		set[s[left:right]] = struct{}{}
	}
	return len(set) == 1<<k
}