/**
 * http://blog.welkinlan.com/2015/04/28/interleaving-string-leetcode-java-dp/
 *
 * For a given position [i,j] in the table, we have two choices:
 * valid[i-1,j] && s1.charAt[i] == s3.charAt[i+j], for e.g., for s1="aabc", s2="db" and s3="aadbbc",
 * as "aab"+"db"=>"aadbb" & "c" of s1 and s3 matches, this case is valid.
 * valid[i,j-1] && s2.charAt[j] == s3.charAt[i+j], for e.g., for s1="aabc", s2="dbb" and s3="aadbbcb",
 * as "aabc"+"db"=>"aadbbc" & "b" of s2 and s3 matches, this case is valid.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) {
            return true;
        }
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }

        boolean valid[] = new boolean[s2.length()+1];
        for (int j = 1; j <= s2.length(); j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                valid[j] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            if (i == 1 && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                valid[0] = true;
            }
            for (int j = 1; j <= s2.length(); j++) {
                valid[j] = (valid[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (valid[j-1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return valid[s2.length()];
    }
}