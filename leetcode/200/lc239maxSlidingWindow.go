func maxSlidingWindow(nums []int, k int) []int {
	n := len(nums)
	dq := []int{}
	ret := make([]int, n-k+1)

	for i := 0; i < n; i++ {
		cur := nums[i]
		for len(dq) > 0 && nums[dq[len(dq)-1]] <= cur {
			dq = dq[:len(dq)-1]
		}

		for len(dq) > 0 && i-dq[0]+1 > k {
			dq = dq[1:]
		}

		dq = append(dq, i)

		if i+1 >= k {
			ret[i+1-k] = nums[dq[0]]
		}
	}

	return ret
}