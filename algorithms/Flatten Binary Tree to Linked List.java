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
  * 想到递归就不难了
  */
public class Solution {
    public void flatten(TreeNode root) {
        flattenHelper(root);
        return;
    }
    
    private TreeNode flattenHelper(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode leftTail = flattenHelper(root.left);
        TreeNode rightTail = flattenHelper(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightTail != null) {
            return rightTail;
        }
        return leftTail;
    }
}