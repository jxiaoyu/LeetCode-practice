/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
  * 在 Maximum Depth of Binary Tree 的基础上改造下。除了要获取深度外还要知道树是否平衡
  */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root).isBalanced;
    }
    
    public Result maxDepth(TreeNode root) {
        if (root == null) {
            return new Result(true, 0);
        }
        Result leftResult = maxDepth(root.left);
        Result rightResult = maxDepth(root.right);

        if (leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.depth - rightResult.depth) <= 1) {
            return new Result(true, Math.max(leftResult.depth, rightResult.depth) + 1);
        } else {
            return new Result(false, 0);
        }
    }
    
    class Result {
        boolean isBalanced;
        int depth;
        
        public Result(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }
    }
}