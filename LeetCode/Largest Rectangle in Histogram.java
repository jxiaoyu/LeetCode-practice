/**
 * naive 的思路两重循环 O(n^2)
 * 这里的思路想明白了也很简单。举个特例：heights 是一个单调增序列，那么过程就是全部入栈，再出栈
 * 对于出栈的 x, 以它为起点所能围成的最大面积，就是 h(x) * x到最右的宽度
 *
 * 推广到一般情况，当一个元素出栈时，求的面积的含义就是
 * 画一条线 y = h, 这条线和直方图围成的面积。这就是 w = stack.empty() ? i : (i - stack.peek() - 1) 的由来
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