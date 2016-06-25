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
 * 在 Construct Binary Tree from Preorder and Inorder Traversal 的基础上稍微改一下就可以了
 */
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] postorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(postorder, ps, ps + i - is - 1, inorder, is, i - 1);
                root.right = buildTree(postorder, ps + i - is, pe - 1, inorder, i + 1, ie);
                break;
            }
        }
        return root;
    }
}