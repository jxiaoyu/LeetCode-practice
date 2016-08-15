public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (!map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), 0);
            }
            map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (!map.containsKey(ransomNote.charAt(i))) {
                return false;
            }
            int temp = map.get(ransomNote.charAt(i)) - 1;
            if (temp < 0) return false;
            map.put(ransomNote.charAt(i), temp);
        }
        return true;
    }
}