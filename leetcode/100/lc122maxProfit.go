func maxProfit(prices []int) int {
	ret := 0
	for i, v := range prices {
		if i+1 < len(prices) && prices[i+1] > v {
			ret += prices[i+1] - v
		}
	}
	return ret
}