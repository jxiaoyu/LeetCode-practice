/**
 * 拿到题没思路，看了别人的答案，只能说思路确实巧
 * 
 * After an element is checked, it should be removed from the set. 
 * Otherwise, time complexity would be O(mn) in which m is the average length of all consecutive sequences.
 */
public class Solution {
    public static int longestConsecutive(int[] num) {
        if (num.length == 0) {
            return 0;
        }
     
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;
     
        for (int e : num)
            set.add(e);
     
        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
     
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
     
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
     
            max = Math.max(count, max);
        }
     
        return max;
    }
}