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
    public boolean isValidBST(TreeNode root) {
        return isValidBst(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean isValidBst(TreeNode root, double min, double max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBst(root.left, min, root.val) && isValidBst(root.right, root.val, max);
    }
}