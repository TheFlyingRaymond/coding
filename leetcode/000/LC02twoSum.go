func twoSum(nums []int, target int) []int {
	vIdxmap := make(map[int]int)
	for i, v := range nums {
		if v2, ok := vIdxmap[target-v]; ok {
			return []int{i, v2}
		}
		vIdxmap[v] = i
	}
	return nil
}