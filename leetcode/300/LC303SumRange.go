type NumArray struct {
	slice []int
}

func Constructor(nums []int) NumArray {
	sl := make([]int, len(nums)+1)
	for i := 1; i <= len(nums); i++ {
		sl[i] = sl[i-1] + nums[i-1]
	}
	return NumArray{slice: sl}
}

func (this *NumArray) SumRange(left int, right int) int {
	return this.slice[right+1] - this.slice[left]
}