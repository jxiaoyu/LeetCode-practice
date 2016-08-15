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
  * 递归思想
  */
public class Solution {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = maxPathSumFromRoot(root.left) + maxPathSumFromRoot(root.right) + root.val;
        if (root.left != null) {
            val = Math.max(maxPathSum(root.left), val);
        }
        if (root.right != null) {
            val = Math.max(maxPathSum(root.right), val);
        }
        return val;
    }
    
    private Map<TreeNode, Integer> map = new HashMap<>();
    
    private int maxPathSumFromRoot(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer i = map.get(root);
        if (i != null) {
            return i;
        }
        int val = Math.max(root.val + Math.max(maxPathSumFromRoot(root.left), maxPathSumFromRoot(root.right)), 0);
        map.put(root, val);
        return val;
    }
}