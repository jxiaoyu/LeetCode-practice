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
  * 考察 dfs，最近这种代码 dfs 已经写了不止一次了
  */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs(list, "", root);
        return list;
    }
    
    private List<String> list = new ArrayList<>();
    
    private void dfs(List<String> list, String path, TreeNode n) {
        if (path == "") {
            path = path + n.val;
        } else {
            path = path + "->" + n.val;
        }
        if (n.left == null && n.right == null) {
            list.add(path);
            return;
        }
        if (n.left != null) {
            dfs(list, path, n.left);
        }
        if (n.right != null) {
            dfs(list, path, n.right);
        }
    }
}