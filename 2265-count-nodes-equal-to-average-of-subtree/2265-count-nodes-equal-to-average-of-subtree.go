/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func averageOfSubtree(root *TreeNode) int {
 result:=0
      
var dfs func(node *TreeNode)(int,int)
dfs=func(node *TreeNode)(int,int){
      
    

     if node == nil{
        return 0,0
     }

     leftsum,left:= dfs(node.Left)
    rightsum, right  := dfs(node.Right)
     
     sum := leftsum+rightsum+node.Val
     count:=left+right+1

     if (sum/count == node.Val){
        result++
     }
  return sum,count
  

}
dfs(root);
      return result
 
}