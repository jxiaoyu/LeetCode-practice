public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int end = prefix.length();
        for (int i = 1; i < strs.length; i++) {
            int j = Math.min(end, strs[i].length());
            int k = 0;
            for (; k < j; k++) {
                if (prefix.charAt(k) != strs[i].charAt(k)) {
                    break;
                }
            }
            end = k;
        }
        return prefix.substring(0, end);
    }
}