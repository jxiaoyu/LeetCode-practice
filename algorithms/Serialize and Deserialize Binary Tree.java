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
 * 没什么难点，树的 bfs 已经写了好多遍了
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.size() != 0) {
            TreeNode node = queue.remove();
            if (node == null) {
                builder.append(",null");
            } else {
                if (builder.length() == 0) {
                    builder.append(node.val);
                } else {
                    builder.append("," + node.val);
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 0;
        while (queue.size() != 0) {
            TreeNode node = queue.remove();
            String left = arr[++i];
            String right = arr[++i];
            if (!left.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }
            if (!right.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));