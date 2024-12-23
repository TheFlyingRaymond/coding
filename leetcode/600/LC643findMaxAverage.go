func findMaxAverage(nums []int, k int) float64 {
	sum, max := 0, 0
	left, right := 0, k

	for i := 0; i < right; i++ {
		sum += nums[i]
	}
	max = sum

	for right < len(nums) {
		sum += nums[right]
		right += 1
		sum -= nums[left]
		left += 1
		if sum > max {
			max = sum
		}
	}

	return float64(max) / float64(k)
}