func searchInsert(nums []int, target int) int {
	left, right := 0, len(nums)

	for left < right {
		mid := left + (right-left)/2
		tmp := nums[mid]

		if tmp == target {
			return mid
		}

		if target < tmp {
			right = mid
		} else {
			left = mid + 1
		}
	}

	return left
}