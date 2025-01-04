func searchRange(nums []int, target int) []int {
	return []int{findLeft(nums, target), findRight(nums, target)}
}

func findLeft(nums []int, target int) int {
	if nums == nil || len(nums) < 1 {
		return -1
	}

	left, right := -1, len(nums)

	for left+1 < right {
		mid := left + (right-left+1)/2
		tmp := nums[mid]
		if target <= tmp {
			right = mid
		} else {
			left = mid
		}
	}

	// 检查 left 是否在数组范围内并且是否匹配目标值
	if left+1 < len(nums) && nums[left+1] == target {
		return left + 1
	}
	return -1
}
func findRight(nums []int, target int) int {
	if nums == nil || len(nums) < 1 {
		return -1
	}

	left, right := 0, len(nums)

	for left < right {
		mid := left + (right-left)/2
		tmp := nums[mid]

		if target < tmp {
			right = mid
		} else {
			left = mid + 1
		}
	}

	// right-1 才是有效值，这即是：对有效指针进行检查后返回结果
	if right-1 >= 0 && nums[right-1] == target {
		return right - 1
	}
	return -1
}