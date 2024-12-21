func trap(height []int) int {
	ret := 0
	stack := []int{}

	for i, v := range height {
		curHeight := v
		for len(stack) > 0 && height[stack[len(stack)-1]] <= curHeight {
			midHeight := height[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]

			if len(stack) > 0 {
				lefIdx := stack[len(stack)-1]
				leftHeight := height[lefIdx]
				ret = ret + (min(curHeight, leftHeight)-midHeight)*(i-lefIdx-1)
			}

		}
		stack = append(stack, i)
	}
	return ret
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
