public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] arr = new char[s.length()];
        int m = 0, t = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j = j + t) {
                if (i == 0 || i == numRows - 1) {
                    arr[m++] = s.charAt(j);
                } else {
                    arr[m++] = s.charAt(j);
                    if (t + j - 2 * i < s.length()) {
                        arr[m++] = s.charAt(t + j - 2 * i);
                    }
                }
            }
        }
        return new String(arr);
    }
}