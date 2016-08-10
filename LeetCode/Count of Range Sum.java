/**
 * bst
 * http://huntzhan.org/leetcode-count-of-range-sum/
 */
class BST {
    private BSTNode root;

    public void insert(long val) {
        root = insert(root, val);
    }

    private BSTNode insert(BSTNode p, long val) {
        if (p == null) {
            return new BSTNode(val);
        }
        if (val < p.val) {
            p.left = insert(p.left, val);
        } else {
            p.right = insert(p.right, val);
        }
        p.size++;
        return p;
    }

    public int rangeCount(long lower, long upper) {
        return countGEQ(lower) - countGEQ(upper + 1);
    }

    private int countGEQ(long val) {
        int count = 0;
        BSTNode p = root;
        while (p != null) {
            if (val > p.val) {
                p = p.right;
            } else if (p.val == val) {
                count += (p.right == null ? 0 : p.right.size) + 1;
                break;
            } else {
                count += (p.right == null ? 0 : p.right.size) + 1;
                p = p.left;
            }
        }
        return count;
    }
}

class BSTNode {
    long val;
    int size = 1;
    BSTNode left, right;

    public BSTNode(long val) {
        this.val = val;
    }
}

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length+1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }

        BST bst = new BST();
        int result = 0;
        for (int i = sum.length - 1; i > 0; i--) {
            bst.insert(sum[i]);
            result += bst.rangeCount(sum[i-1] + lower, sum[i-1] + upper);
        }
        return result;
    }
}