func maxArea(height []int) int {
	left, right := 0, len(height)-1
	ret := 0
	for left < right {
		lv, rv := height[left], height[right]
		area := (right - left) * min(lv, rv)
		if area > ret {
			ret = area
		}

		if lv < rv {
			left++
		} else {
			right--
		}
	}
	return ret
}