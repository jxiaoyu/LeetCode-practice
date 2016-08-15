/**
 * 非典型 dfs
 * https://discuss.leetcode.com/topic/34875/easy-short-concise-and-fast-java-dfs-3-ms-solution/2
 */
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        dfs(s, 0, 0, new StringBuilder(), new char[]{'(', ')'});
        return res;
    }

    private List<String> res = new ArrayList<>();

    private void dfs(String s, int pos, int lastRemove, StringBuilder prefix, char[] par) {
        int count = 0, i = pos;
        for (; i < s.length(); i++) {
            prefix.append(s.charAt(i));
            if (s.charAt(i) == par[0]) {
                count++;
            } else if (s.charAt(i) == par[1]) {
                count--;
            }
            if (count >= 0) {
                continue;
            }
            for (int j = lastRemove; j < prefix.length(); j++) {
                if (prefix.charAt(j) == par[1] && (j == 0 || prefix.charAt(j - 1) != par[1])) {
                    StringBuilder newPrefix = new StringBuilder(prefix);
                    dfs(s, i + 1, j, newPrefix.deleteCharAt(j), par);
                }
            }
            return;
        }

        prefix.reverse();
        if (par[0] == '(') {
            dfs(prefix.toString(), 0, 0, new StringBuilder(), new char[]{')', '('});
        } else {
            res.add(prefix.toString());
        }
    }
}