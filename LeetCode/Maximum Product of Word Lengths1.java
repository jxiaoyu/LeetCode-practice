/**
 * 朴素的做法，果不其然超时了
 */
public class Solution {
    public int maxProduct(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }

            for (int j = i; j < words.length; j++) {
                int k = 0;
                for (; k < words[j].length(); k++) {
                    if (set.contains(words[j].charAt(k))) {
                        break;
                    }
                }
                if (k == words[j].length()) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
}