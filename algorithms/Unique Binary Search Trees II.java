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
 * 有了 Unique Binary Search Trees 的基础，这题就不难了
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int min, int max) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (min > max) {
            list.add(null);
            return list;
        }
        for (int i = min; i < max + 1; i++) {
            List<TreeNode> left = generateTrees(min, i - 1);
            List<TreeNode> right = generateTrees(i + 1, max);
            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}