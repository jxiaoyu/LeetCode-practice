public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int len = citations.length, l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] >= len - mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return Math.min(len - l, citations[l]);
    }
}