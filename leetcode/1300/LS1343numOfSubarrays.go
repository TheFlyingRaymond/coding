func numOfSubarrays(nums []int, k int, threshold int) int {
	if k > len(nums) {
		return 0
	}

	cnt, sum := 0, 0
	left, right := 0, k
	thresholdSum := k * threshold

	for i := 0; i < right; i++ {
		sum += nums[i]
	}
	if sum >= thresholdSum {
		cnt += 1
	}

	for right < len(nums) {
		sum += nums[right]
		right++
		sum -= nums[left]
		left++
		if sum >= thresholdSum {
			cnt++
		}
	}

	return cnt
}