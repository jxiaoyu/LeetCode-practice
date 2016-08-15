/**
 * 双指针
 * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, 
 * and keep two pointers which define the max substring. 
 * move the right pointer to scan through the string , and meanwhile update the hashmap. 
 * If the character is already in the hashmap, then move the left pointer to the right of the same character last found
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0, right = 0, result = 0;
        while (right < s.length()) {
            Integer dupIndex = map.get(s.charAt(right));
            if (dupIndex != null && dupIndex >= left) {
                left = map.get(s.charAt(right)) + 1;
            } else {
                result = Math.max(result, right - left + 1);
            }
            map.put(s.charAt(right), right++);
        }
        return result;
    }
}