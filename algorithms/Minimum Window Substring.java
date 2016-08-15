/**
 * 一开始是完全按照 Substring with Concatenation of All Words 的思路来做的，时间复杂度 O(n^2)
 * 过最大的测试用例时超时了，想到把 hashMap 换成数组，依然超时
 * 后来看到这种做法，区别只是在没有两层遍历，而是用一个滑动窗，或者说双指针，时间复杂度 O(n)
 */
public class Solution {
    public String minWindow(String s, String t) {
        int min = s.length() + 1;
        String res = "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int begin = 0, end = 0, count = t.length();
        while (end < s.length()) {
            char c = s.charAt(end++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count--;
                }
            }
            while (count == 0) {
                if (end - begin < min) {
                    min = end -begin;
                    res = s.substring(begin, end);
                }
                c = s.charAt(begin++);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        count++;
                    }
                }
            }
        }
        return res;
    }
}