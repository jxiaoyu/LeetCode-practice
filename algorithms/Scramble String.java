/**
 * brutal method 
 * 因为 T(n) = T(1) + T(2) + ... + T(n-2) + T(n-1), 所以 T(n) = 2T(n-1), 时间复杂度 O(2^n)
 * 没有剪枝是过不了的
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1==null || s2==null || s1.length()!=s2.length()) {
            return false;
        }

        //this is to judge when recursion only pass one letter
        if(s1.length()==1 && s2.length()==1){  
            return s1.charAt(0) == s2.charAt(0);  
        }

        char[] cArray1 = s1.toCharArray();
        char[] cArray2 = s2.toCharArray();
        Arrays.sort(cArray1);
        Arrays.sort(cArray2);
        
        // 剪枝
        if (!String.valueOf(cArray1).equals(String.valueOf(cArray2))) {
            return false;
        }

        for (int i=1; i<s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0, i);
            String s22 = s2.substring(i);

            //test front part
            if (isScramble(s11,s21) && isScramble(s12, s22)) {
                return true;
            }

            //test the back part
            s21 = s2.substring(s2.length()-i);
            s22 = s2.substring(0, s2.length()-i);
            if (isScramble(s11, s21) && isScramble(s12, s22)) {
                return true;
            }
        }     
        return false;
    }
}