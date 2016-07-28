/**
 * 思路来自 https://discuss.leetcode.com/topic/41477/the-easy-to-unserstand-java-solution/2
 * 
 * Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.
 * Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
 * Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.
 * Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            if (s.length() == 0) {
                continue;
            }
            addRecord(s, i, map, list, true);

            boolean[][] dp = new boolean[s.length()][s.length()];
            dp[0][0] = true;
            addRecord(s.substring(1), i, map, list, false);
            if (s.length() == 1) {
                addRecord(s.substring(1), i, map, list, true);
            }

            for (int n = 1; n < s.length(); n++) {
                for (int m = n; m >= 0; m--) {
                    if (s.charAt(m) == s.charAt(n) && (m + 1 >= n || dp[m+1][n-1])) {
                        dp[m][n] = true;
                        if (m == 0) {
                            addRecord(s.substring(n + 1), i, map, list, false);
                        }
                        if (n == s.length() - 1) {
                            addRecord(s.substring(0, m), i, map, list, true);
                        }
                    }
                }
            }
        }
        return list;
    }

    private void addRecord(String s, int i, Map<String, Integer> map, List<List<Integer>> list, boolean first) {
        if (map.containsKey(reverse(s))) {
            int pair = map.get(reverse(s));
            if (pair == i) {
                return;
            }
            List<Integer> res = new ArrayList<Integer>();
            if (first) {
                res.add(i);
                res.add(pair);
            } else {
                res.add(pair);
                res.add(i);
            }
            list.add(res);
        }
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}