/**
 * 先做的 Surrounded Regions，在其基础上稍微修改下就可以了
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length < 1) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[][] tags = new int[m][n];
        int tag = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1' && tags[i][j] == 0) {
                    tags[i][j] = tag;

                    Stack<Integer> xStack = new Stack<Integer>();
                    Stack<Integer> yStack = new Stack<Integer>();
                    xStack.push(i);
                    yStack.push(j);

                    while (!xStack.empty()) {
                        int a = xStack.pop(), b = yStack.pop();

                        if (a - 1 >= 0 && grid[a-1][b] == '1' && tags[a-1][b] == 0) {
                            tags[a-1][b] = tag;
                            xStack.push(a - 1);
                            yStack.push(b);
                        }
                        if (b - 1 >= 0 && grid[a][b-1] == '1' && tags[a][b-1] == 0) {
                            tags[a][b-1] = tag;
                            xStack.push(a);
                            yStack.push(b - 1);
                        }
                        if (a + 1 <= m - 1 && grid[a+1][b] == '1' && tags[a+1][b] == 0) {
                            tags[a+1][b] = tag;
                            xStack.push(a + 1);
                            yStack.push(b);
                        }

                        if (b + 1 <= n - 1 && grid[a][b+1] == '1' && tags[a][b+1] == 0) {
                            tags[a][b+1] = tag;
                            xStack.push(a);
                            yStack.push(b + 1);
                        }
                    }
                    tag++;
                }
        }
        return tag - 1;
    }
}