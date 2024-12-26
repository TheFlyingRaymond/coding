func maxSum(nums []int, m int, k int) int64 {
	var sum, max int64
	left, right := 0, k
	freqMap := make(map[int]int)

	for i := 0; i < right; i++ {
		sum += int64(nums[i])
		freqMap[nums[i]]++
	}

	if len(freqMap) >= m {
		max = sum
	}

	for right < len(nums) {
		sum += int64(nums[right])
		freqMap[nums[right]]++
		right++

		sum -= int64(nums[left])
		freqMap[nums[left]]--
		if freqMap[nums[left]] == 0 {
			delete(freqMap, nums[left])
		}
		left++

		if len(freqMap) >= m && sum > max {
			max = sum
		}
	}

	return max
}