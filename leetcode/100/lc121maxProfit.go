func maxProfit(prices []int) int {
	minv := prices[0]
	ret := 0

	for _, v := range prices {
		if v-minv > ret {
			ret = v - minv
		}
		if v < minv {
			minv = v
		}
	}

	return ret
}