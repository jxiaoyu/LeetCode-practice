/**
 * naive 的思路两重循环 O(n^2)
 * 这里的思路来自 http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] h = Arrays.copyOf(heights, heights.length + 1);
        Stack<Integer> stack = new Stack<>();
        int i = 0, max = 0;
        while (i < h.length) {
            if (stack.empty() || h[i] >= h[stack.peek()]) {
                stack.push(i++);
            } else {
                Integer p = stack.pop();
                int w = stack.empty() ? i : (i - stack.peek() - 1);
                max = Math.max(w * h[p], max);
            }
        }
        return max;
    }
}