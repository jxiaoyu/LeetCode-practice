/**
 * 运用了 Largest Rectangle in Histogram 的方法做了一遍
 * 时间复杂度 O(n^2)
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, max = 0;

        int[] heights = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] = i - 1 >= 0 ? heights[j] + 1 : 1;
                } else {
                    heights[j] = 0;
                }
            }
            max = Math.max(largestRectangleArea(heights), max);
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
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