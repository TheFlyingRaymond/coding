func getAverages(nums []int, k int) []int {
	ret := make([]int, len(nums))
	for i := range ret {
		ret[i] = -1
	}

	win := k*2 + 1
	if len(nums) < win {
		return ret
	}

	left, right := 0, win
	var sum int64 = 0
	for i := 0; i < right; i++ {
		sum += int64(nums[i])
	}
	ret[right-k-1] = int(sum / int64(win))

	for right < len(nums) {
		sum += int64(nums[right])
		right++
		sum -= int64(nums[left])
		left++
		ret[right-k-1] = int(sum / int64(win))
	}

	return ret
}