func moveZeroes(nums []int) {
	idx := 0
	for _, v := range nums {
		nums[idx] = v
		if v != 0 {
			idx++
		}
	}

	for idx < len(nums) {
		nums[idx] = 0
		idx++
	}
}