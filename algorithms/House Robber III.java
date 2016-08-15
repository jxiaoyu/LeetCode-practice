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
  * 想到用递归的思路来解就不难了
  */
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum1 = rob(root.left) + rob(root.right);
        int sum2 = root.val;
        if (root.left != null) {
            sum2 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sum2 += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(sum1, sum2);
    }
}