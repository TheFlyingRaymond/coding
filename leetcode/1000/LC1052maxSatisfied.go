func maxSatisfied(customers []int, grumpy []int, minutes int) int {
	sum, max := 0, 0
	left, right := 0, minutes

	for i := 0; i < len(customers); i++ {
		if grumpy[i] == 0 {
			sum += customers[i]
		}
	}

	for i := 0; i < right; i++ {
		if grumpy[i] == 1 {
			sum += customers[i]
		}
	}
	max = maxInt(max, sum)

	for right < len(customers) {
		if grumpy[right] == 1 {
			sum += customers[right]
		}
		right++

		if grumpy[left] == 1 {
			sum -= customers[left]
		}
		left++

		max = maxInt(max, sum)
	}
	return max
}

func maxInt(a int, b int) int {
	if a > b {
		return a
	}
	return b
}