/**
 * 数据结构考察二维数组的初始化和使用
 * 算法考 dfs
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, word, visited, i, j, 1)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private int[][] offset = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean dfs(char[][] board, String word, boolean[][] visited, int x, int y, int depth) {
        if (word.length() == depth) {
            return true;
        }

        for (int i = 0; i < offset.length; i++) {
            int x1 = x + offset[i][0];
            int y1 = y + offset[i][1];
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && !visited[x1][y1] && board[x1][y1] == word.charAt(depth)) {
                visited[x1][y1] = true;
                if (dfs(board, word, visited, x1, y1, depth + 1)) {
                    return true;
                }
                visited[x1][y1] = false;
            }
        }
        return false;
    }

}