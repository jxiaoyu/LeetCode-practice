/**
 * 用 segment tree
 */

class TreeNode {
    int start;
    int end;
    int sum;
    TreeNode left;
    TreeNode right;

    public TreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    public TreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
    }
}

public class NumArray {

    private TreeNode root;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            root = buildTree(nums, 0, nums.length - 1);
        }
    }

    public int sumRange(int i, int j) {
        return sumRangeHelper(root, i, j);
    }

    private int sumRangeHelper(TreeNode root, int i, int j) {
        if (root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (j <= mid) {
            return sumRangeHelper(root.left, i, j);
        } else if (i >= mid + 1) {
            return sumRangeHelper(root.right, i, j);
        }
        return sumRangeHelper(root.left, i, mid) + sumRangeHelper(root.right, mid + 1, j);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;
        TreeNode left = buildTree(nums, start, mid);
        TreeNode right = buildTree(nums, mid + 1, end);
        TreeNode root = new TreeNode(start, end);
        root.left = left;
        root.right = right;
        root.sum = left.sum + right.sum;
        return root;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);