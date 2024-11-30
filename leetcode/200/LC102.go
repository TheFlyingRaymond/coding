func levelOrder(root *TreeNode) [][]int {
	ret := [][]int{}
	if root == nil{
		return ret;
	}

	layer := []*TreeNode{root}
	for i:=0; len(layer) > 0; i++{
		ret = append(ret, []int{})

		cnt := len(layer)

		newLayer := []*TreeNode{}
		for j := 0; j < cnt; j++{
			node := layer[j]
			ret[i] = append(ret[i],node.Val)

			if node.Left != nil{
				newLayer = append(newLayer,node.Left)
			}
			if node.Right != nil{
				newLayer = append(newLayer,node.Right)
			}
		}

		layer = newLayer
	}

	return ret
}