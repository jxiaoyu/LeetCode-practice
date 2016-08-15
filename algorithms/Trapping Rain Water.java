/**
 * 想到用栈这个数据结构，再把出栈入栈的情况想清楚就不难了
 */
class Coord {
    public int x, y;
    
    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Coord> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0) {
                continue;
            }
            int lastHeight = 0;
            while (!stack.empty()) {
                Coord coord = stack.peek();
                sum += (i - coord.x - 1) * (Math.min(height[i], coord.y) - lastHeight);
                if (coord.y <= height[i]) {
                    lastHeight = coord.y;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(new Coord(i, height[i]));
        }
        return sum;
    }
}