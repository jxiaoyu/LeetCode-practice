public class Solution extends VersionControl {

    public int firstBadVersion(int n) {

        int left = 1, right = n, mid;

        while (true) {

            // 技巧1：当 left, right 都很大的时候，left + (right - left) / 2 比 (right + left) / 2 快很多
            mid = left + (right - left) / 2;
            if (mid == left) {
                return isBadVersion(left) ? left : right;
            }
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }
}