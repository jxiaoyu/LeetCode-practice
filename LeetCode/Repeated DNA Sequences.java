/**
 * 简单直接的做法
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int index = 10; index <= s.length(); index++) {
            String subStr = s.substring(index - 10, index);
            if (!set.add(subStr)) {
                resultSet.add(subStr);
            }
        }
        res.addAll(resultSet);
        return res;
    }
}