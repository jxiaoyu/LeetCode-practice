import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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
 * 这是自己想到的版本，按广度优先给节点编号。然后找出 lowest common ancestor 的编号
 * 另一版本更好地用到了 bst 的特点
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int m = search(root, p, 1);
        int n = search(root, q, 1);
        while (m != n) {
            if (m > n) {
                m /= 2;
            } else {
                n /= 2;
            }
        }
        return map.get(m);
    }

    private Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();

    private int search(TreeNode root, TreeNode s, int no) {
        map.put(no, root);
        if (root.val == s.val) {
            return no;
        }
        if (s.val < root.val) {
            root = root.left;
            no = no * 2;
        } else {
            root = root.right;
            no = no * 2 + 1;
        }
        return search(root, s, no);
    }

}