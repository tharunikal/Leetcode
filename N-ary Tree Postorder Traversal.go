/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func postorder(root *Node) []int {
    res := []int{}
    dp(root, &res)
    return res
}

func dp(root *Node, arr *[]int) {
    if root == nil {
        return
    }
    
    for _, v := range root.Children {
        dp(v, arr)
    }
    
    *arr = append(*arr, root.Val)
}
