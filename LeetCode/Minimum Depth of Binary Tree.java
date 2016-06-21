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
 * 思路：dfs 加减枝
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepth(root, 1);
        return min;
    }
    
    private int min = Integer.MAX_VALUE;
    
    public void minDepth(TreeNode root, int depth) {
        if (depth >= min) {
            return;
        }
        if (root.left == null && root.right == null) {
            min = depth;
            return;
        }
        if (root.left != null) {
            minDepth(root.left, depth + 1);
        }
        if (root.right != null) {
            minDepth(root.right, depth + 1);
        }
    }
}