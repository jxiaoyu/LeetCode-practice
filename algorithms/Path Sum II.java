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
 * 考察 dfs，在 Binary Tree Paths 的基础上修改下即可
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return list;
        }
        dfs(list, new ArrayList<Integer>(), sum, root);
        return list;
    }
    
    private List<List<Integer>> list = new ArrayList<>();
    
    private void dfs(List<List<Integer>> list, List<Integer> path, int target, TreeNode n) {
        path.add(n.val);
        if (n.left == null && n.right == null) {
            if (n.val == target) {
                list.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if (n.left != null) {
            dfs(list, path, target - n.val, n.left);
            path.remove(path.size() - 1);
        }
        if (n.right != null) {
            dfs(list, path, target - n.val, n.right);
            path.remove(path.size() - 1);
        }
    }
}