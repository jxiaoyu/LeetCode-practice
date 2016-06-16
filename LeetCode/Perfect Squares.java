import java.util.HashMap;
import java.util.Map;

/**
 * 这题主要考察 dp 思想
 * 一开始用的 bfs 超时
 * 这里 dp 可以进一步优化成顺序而非递归的
 */
public class Solution {
    public int numSquares(int n) {
        return numSquaresHelper(n);
    }

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    private int numSquaresHelper(int n) {
        Integer count = map.get(n);
        if (count != null) {
            return count;
        }
        int root = (int)Math.sqrt(n);
        if (root * root == n) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i < n / 2 + 1; i++) {
            int num = numSquaresHelper(n - i * i);
            if (num < min) {
                min = num;
            }
        }
        map.put(n, min + 1);
        return min + 1;
    }
}