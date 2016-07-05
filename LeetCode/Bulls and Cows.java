public class Solution {
    public String getHint(String secret, String guess) {
        int[] digits = new int[10];
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            int d = secret.charAt(i) - '0';
            digits[d]++; 
        }
        
        for (int i = 0; i < guess.length(); i++) {
            int d = guess.charAt(i) - '0';
            if (guess.charAt(i) == secret.charAt(i)) {
                bulls++;
                digits[d]--;
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            int d = guess.charAt(i) - '0';
            if (guess.charAt(i) == secret.charAt(i)) {
                continue;
            } else if (digits[d] > 0) {
                cows++;
                digits[d]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}