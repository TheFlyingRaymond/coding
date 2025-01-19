func trap(height []int) int {
	n := len(height)
	stack := Stack{}
	ret := 0

	for i := 0; i < n; i++ {
		curHeight := height[i]
		for stack.Size() > 0 {
			lastIdx, _ := stack.Peek()
			if height[lastIdx] > curHeight {
				break
			}
			midIdx, _ := stack.Pop()
			midHeight := height[midIdx]

			if stack.Size() == 0 {
				break
			}

			leftIdx, _ := stack.Peek()
			leftHeight := height[leftIdx]
			add := (i - leftIdx - 1) * (min(curHeight, leftHeight) - midHeight)
			ret += add
		}
		stack.Push(i)
	}
	return ret
}

// Stack 定义一个栈结构
type Stack struct {
	elements []int
}

// Push 将元素入栈
func (s *Stack) Push(value int) {
	s.elements = append(s.elements, value)
}

// Pop 将栈顶元素出栈，并返回该元素
func (s *Stack) Pop() (int, bool) {
	if len(s.elements) == 0 {
		return 0, false // 栈为空，返回false
	}
	// 获取栈顶元素
	top := s.elements[len(s.elements)-1]
	// 移除栈顶元素
	s.elements = s.elements[:len(s.elements)-1]
	return top, true
}

// Peek 获取栈顶元素，但不出栈
func (s *Stack) Peek() (int, bool) {
	if len(s.elements) == 0 {
		return 0, false // 栈为空，返回false
	}
	return s.elements[len(s.elements)-1], true
}

// IsEmpty 检查栈是否为空
func (s *Stack) IsEmpty() bool {
	return len(s.elements) == 0
}

// Size 返回栈的大小
func (s *Stack) Size() int {
	return len(s.elements)
}
