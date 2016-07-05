public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isAlpha(s.charAt(i))) {
                i++;
                continue;
            } else if (!isAlpha(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    private boolean isAlpha(char c) {
        if (c - 'a' >= 0 && c - 'a' <= 25) {
            return true;
        } else if (c - '0' >= 0 && c - '0' <= 9) {
            return true;
        } else {
            return false;
        }
    }
}