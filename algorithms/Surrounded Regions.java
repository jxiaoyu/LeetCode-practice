/**
 * bfs 的思路
 */
public class Solution {
    public void solve(char[][] board) {
        if (board.length < 1) {
            return;
        }
        int m = board.length, n = board[0].length;
        int[][] tags = new int[m][n];
        int tag = 1;
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++)
                if (board[i][j] == 'O' && tags[i][j] == 0) {
                    boolean enclosed = true;
                    tags[i][j] = tag;

                    Stack<Integer> xStack = new Stack<Integer>();
                    Stack<Integer> yStack = new Stack<Integer>();
                    xStack.push(i);
                    yStack.push(j);

                    while (!xStack.empty()) {
                        int a = xStack.pop(), b = yStack.pop();
                        if (a - 1 < 0) {
                            enclosed = false;
                        } else if (board[a-1][b] == 'O' && tags[a-1][b] == 0) {
                            tags[a-1][b] = tag;
                            xStack.push(a - 1);
                            yStack.push(b);
                        }
                        if (b - 1 < 0) {
                            enclosed = false;
                        } else if (board[a][b-1] == 'O' && tags[a][b-1] == 0) {
                            tags[a][b-1] = tag;
                            xStack.push(a);
                            yStack.push(b - 1);
                        }
                        if (a + 1 > m - 1) {
                            enclosed = false;
                        } else if (board[a+1][b] == 'O' && tags[a+1][b] == 0) {
                            tags[a+1][b] = tag;
                            xStack.push(a + 1);
                            yStack.push(b);
                        }
                        if (b + 1 > n - 1) {
                            enclosed = false;
                        } else if (board[a][b+1] == 'O' && tags[a][b+1] == 0) {
                            tags[a][b + 1] = tag;
                            xStack.push(a);
                            yStack.push(b + 1);
                        }
                    }
                    if (enclosed) {
                        set.add(tag);
                    }
                    tag++;
                }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (set.contains(tags[i][j])) {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
}