func nodesBetweenCriticalPoints(head *ListNode) []int {
	if head == nil || head.Next == nil || head.Next.Next == nil {
		return []int{-1, -1}
	}

	cnt := 0
	ptr1 := head
	ptr2 := ptr1.Next
	ptr3 := ptr2.Next

	pos := []int{}

	for ptr3 != nil {
		cnt += 1
		if ptr2.Val > ptr1.Val && ptr2.Val > ptr3.Val {
			pos = append(pos, cnt+1)
		}
		if ptr2.Val < ptr1.Val && ptr2.Val < ptr3.Val {
			pos = append(pos, cnt+1)
		}
		ptr1 = ptr1.Next
		ptr2 = ptr2.Next
		ptr3 = ptr3.Next
	}

	if len(pos) < 2 {
		return []int{-1, -1}
	}

	min := pos[1] - pos[0]
	max := pos[len(pos)-1] - pos[0]
	for i := 1; i < len(pos)-1; i++ {
		if pos[i+1]-pos[i] < min {
			min = pos[i+1] - pos[i]
		}
	}
	return []int{min, max}
}

type ListNode struct {
	Val  int
	Next *ListNode
}