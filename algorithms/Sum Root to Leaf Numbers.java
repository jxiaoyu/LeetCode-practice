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
 * dfs 就搞定了
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }
    
    private int sum = 0;
    
    private void dfs(TreeNode node, int num) {
        if (node.left == null & node.right == null) {
            sum += (num * 10 + node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, num * 10 + node.val);
        }
        if (node.right != null) {
            dfs(node.right, num * 10 + node.val);
        }
    }
}