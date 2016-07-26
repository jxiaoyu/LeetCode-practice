/**
 * all possible solution 问题，自然想到 dfs
 */
public class Solution {
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList());
        return list;
    }

    private List<List<String>> list = new ArrayList<List<String>>();

    private void dfs(String s, int pos, List<String> res) {
        if (pos >= s.length()) {
            list.add(new ArrayList(res));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isPalindrome(sb)) {
                res.add(sb.toString());
                dfs(s, i + 1, res);
                res.remove(res.size() - 1);
            }
        }
    }

    private boolean isPalindrome(StringBuilder s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}