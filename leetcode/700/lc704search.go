func search(nums []int, target int) int {
	if nums == nil || len(nums) < 1 {
		return -1
	}

	left, right := -1, len(nums)-1

	for left+1 <= right {
		mid := left + (right-left+1)/2
		tmp := nums[mid]
		if tmp == target {
			return mid
		}

		if target < tmp {
			right = mid - 1
		} else {
			left = mid
		}
	}

	return -1
}

// func search(nums []int, target int) int {
// 	if nums == nil || len(nums) < 1 {
// 		return -1
// 	}

// 	left, right := -1, len(nums)

// 	for left+1 < right {
// 		mid := left + (right-left+1)/2
// 		tmp := nums[mid]
// 		if tmp == target {
// 			return mid
// 		}

// 		if target < tmp {
// 			right = mid
// 		} else {
// 			left = mid
// 		}
// 	}

// 	return -1
// }

// func search(nums []int, target int) int {
// 	if nums == nil || len(nums) < 1 {
// 		return -1
// 	}

// 	left, right := 0, len(nums)

// 	for left < right {
// 		mid := left + (right-left)/2
// 		tmp := nums[mid]
// 		if tmp == target {
// 			return mid
// 		}

// 		if target < tmp {
// 			right = mid
// 		} else {
// 			left = mid + 1
// 		}
// 	}

// 	return -1
// }

// func search(nums []int, target int) int {
// 	if nums == nil || len(nums) < 1 {
// 		return -1
// 	}

// 	left, right := 0, len(nums)-1

// 	for left <= right {
// 		mid := left + (right-left)/2
// 		tmp := nums[mid]
// 		if tmp == target {
// 			return mid
// 		}

// 		if target < tmp {
// 			right = mid - 1
// 		} else {
// 			left = mid + 1
// 		}
// 	}

// 	return -1
// }