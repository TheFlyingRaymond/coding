func longestConsecutive(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	m := map[int]bool{}
	for _, v := range nums {
		m[v] = true
	}

	ret := 0
	//在很多重复值的情况下遍历map会高效
	for num := range m {
		//精髓的num-1判断
		if !m[num-1] {
			tmp := 1
			current := num
			for m[current+1] {
				current++
				tmp++
			}
			ret = max(ret, tmp)
		}
	}

	return ret
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
