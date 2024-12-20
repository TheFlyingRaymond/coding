func merge(nums1 []int, m int, nums2 []int, n int) {
	ptr := m + n - 1

	ptr1 := m - 1
	ptr2 := n - 1

	for ptr1 >= 0 || ptr2 >= 0 {
		if ptr1 < 0 {
			nums1[ptr] = nums2[ptr2]
			ptr2 = ptr2 - 1
		} else if ptr2 < 0 {
			nums1[ptr] = nums1[ptr1]
			ptr1 -= 1
		} else {
			if nums1[ptr1] >= nums2[ptr2] {
				nums1[ptr] = nums1[ptr1]
				ptr1 -= 1
			} else {
				nums1[ptr] = nums2[ptr2]
				ptr2 = ptr2 - 1
			}
		}
		ptr -= 1
	}
}