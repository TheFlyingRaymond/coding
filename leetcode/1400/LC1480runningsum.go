func runningSum(nums []int) []int {
	ret := nums[0:len(nums):len(nums)]

	for i, v := range nums {
		if i == 0 {
			ret[i] = v
		} else {
			ret[i] = v + ret[i-1]
		}
	}

	return ret
}