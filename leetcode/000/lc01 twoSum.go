func twoSum(nums []int, target int) []int {
	memo := make(map[int]int)
	for i, v := range nums {
		if v2, ok := memo[target-v]; ok {
			return []int{i, v2}
		}
		memo[v] = i
	}
	return nil
}