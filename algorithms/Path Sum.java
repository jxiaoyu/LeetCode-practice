/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return dfs(sum, root);
    }
    
    private boolean dfs(int target, TreeNode n) {
        if (n.left == null && n.right == null) {
            if (n.val == target) {
                return true;
            }
            return false;
        } 
        return (n.left != null && dfs( target - n.val, n.left)) || (n.right != null && dfs(target - n.val, n.right));
    }
}