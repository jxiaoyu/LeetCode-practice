import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 这题跟 Word Search 很像。所以一开始拿到这题就直接写了个循环调用 Word Search 的 exist 方法，但是发现有的测试用例超时
 * 当需要判断的单词量相对于 board 可能的组合已经比较大的时候，用这种方法就不经济了。还不如遍历棋盘的组合
 * dfs 时用 Trie 来减枝
 *
 * 总结：对入参的规模要敏感
 */

/**
 * 另外注释部分是我自己实现的 dfs，比较自然。
 * 非注释的 dfs 相对来说更简洁，但是运行速度却更慢，应该是因为每次 dfs 都要生成新的 str
 */

public class Solution {

    private Set<String> result = new HashSet<String>();

    private int[][] offset = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
//                StringBuilder builder = new StringBuilder();
//                builder.append(board[i][j]);
//                visited[i][j] = true;
//                dfs(board, builder, trie, visited, i, j);
//                builder.deleteCharAt(0);
//                visited[i][j] = false;
                dfs(board, "", trie, visited, i, j);
            }
        }

        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, String str, Trie trie, boolean[][] visited, int x, int y) {

        if(x < 0 || y < 0|| x >= board.length || y >= board[0].length || visited[x][y]){
            return;
        }

        str = str + board[x][y];

        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        visited[x][y] = true;
        dfs(board, str, trie, visited, x + 1, y);
        dfs(board, str, trie, visited, x - 1, y);
        dfs(board, str, trie, visited, x, y + 1);
        dfs(board, str, trie, visited, x, y - 1);
        visited[x][y] = false;
    }

    private void dfs(char[][] board, StringBuilder builder, Trie trie, boolean[][] visited, int x, int y) {

        String prefix = builder.toString();
        if (!trie.startsWith(prefix)) {
            return;
        }

        if (trie.search(prefix)) {
            result.add(prefix);
        }

        for (int i = 0; i < offset.length; i++) {
            int x1 = x + offset[i][0];
            int y1 = y + offset[i][1];
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && !visited[x1][y1]) {
                visited[x1][y1] = true;
                builder.append(board[x1][y1]);
                dfs(board, builder, trie, visited, x1, y1);
                visited[x1][y1] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    class TrieNode {

        private TrieNode[] children;

        private String item;

        // Initialize your data structure here.
        public TrieNode() {
            children = new TrieNode[26];
            item = "";
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public String getItem() {
            return item;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode child = node.getChildren()[word.charAt(i) - 'a'];
                if (child == null) {
                    child = new TrieNode();
                    node.getChildren()[word.charAt(i) - 'a'] = child;
                }
                node = child;
            }
            node.setItem(word);
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode child = node.getChildren()[word.charAt(i) - 'a'];
                if (child == null) {
                    return false;
                }
                node = child;
            }
            if (node.getItem().equals(word)) {
                return true;
            }
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                TrieNode child = node.getChildren()[prefix.charAt(i) - 'a'];
                if (child == null) {
                    return false;
                }
                node = child;
            }
            return true;
        }
    }

}