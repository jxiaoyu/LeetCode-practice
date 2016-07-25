/**
 * 用到栈
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] dict = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i) -'a']++;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.contains(cur)) {
                while (!stack.empty() && stack.peek() > cur && dict[stack.peek()-'a'] > 0) {
                    stack.pop();
                }
                stack.push(cur);
            }
            dict[cur-'a']--;
        }
        
        StringBuilder result = new StringBuilder();
        while(!stack.empty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}