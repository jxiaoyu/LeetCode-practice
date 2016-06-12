import java.util.ArrayList;
import java.util.List;

/**
 * Created by river on 2016/6/12.
 */
public class Solution {
    public void nextPermutation(int[] nums) {

        /**
         * 技巧1：字典序的生成规则
         * 1. scan from right to left, find the first element that is less than its previous one
         * 2. scan from right to left, find the first element that is greater than p
         * 3. swap p and q
         * 4. reverse elements [p+1, nums.length]
         */
        if (nums.length <= 1) {
            return;
        }

        int p = -1;
        int i = nums.length - 2;

        while (i >= 0) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            } else {
                i--;
            }
        }

        if (p == -1) {
            reverse(nums, 0);
            return;
        }

        i = nums.length - 1;
        int q = 0;
        while (i >= p + 1) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            } else {
                i--;
            }
        }

        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;

        reverse(nums, p + 1);

    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}