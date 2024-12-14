func runningSum(nums []int) []int {
	ret := make([]int, len(nums))
	ret[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		ret[i] = ret[i-1] + nums[i]
	}
	return ret
}