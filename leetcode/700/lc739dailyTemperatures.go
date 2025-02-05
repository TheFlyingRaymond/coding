func dailyTemperatures(temperatures []int) []int {
	n := len(temperatures)
	ret := make([]int, n)
	stack := []int{}

	for i := n - 1; i >= 0; i-- {
		for len(stack) > 0 && temperatures[stack[len(stack)-1]] <= temperatures[i] {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			ret[i] = 0
		} else {
			ret[i] = stack[len(stack)-1] - i
		}
		stack = append(stack, i)
	}

	return ret
}