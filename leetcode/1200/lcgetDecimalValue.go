func getDecimalValue(head *ListNode) int {
	ret := 0
	ptr := head

	for ptr != nil {
		ret *= 2
		ret += ptr.Val
		ptr = ptr.Next
	}

	return ret
}

type ListNode struct {
	Val  int
	Next *ListNode
}