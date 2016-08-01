/**
 * 设置一个words.length * wordLen长度的滑动窗口，将窗口从左向右滑动，
 * 并将窗口再划分为长度为wordlen的块，依次检查每个块是否包含在words中，并且出现次数也是符合要求的
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0) {
            return list;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        int len = words[0].length();
        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap(map);
            for (int j = i; j <= s.length() - len; j = j + len) {
                String subStr = s.substring(j, j + len);
                if (!copy.containsKey(subStr)) {
                    break;
                } else {
                    int newCount = copy.get(subStr) - 1;
                    if (newCount == 0) {
                        copy.remove(subStr);
                    } else {
                        copy.put(subStr, newCount);
                    }
                }
            }
            if (copy.size() == 0) {
                list.add(i);
            }
        }
        return list;
    }
}