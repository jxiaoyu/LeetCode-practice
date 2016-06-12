import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by river on 2016/6/12.
 */
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        list.add(arrayToList(nums));
        while (nextPermutation(nums)) {
            list.add(arrayToList(nums));
        }
        return list;

    }

    private List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    private boolean nextPermutation(int[] nums) {

        /**
         * 技巧1：字典序的生成规则
         * 1. scan from right to left, find the first element that is less than its previous one
         * 2. scan from right to left, find the first element that is greater than p
         * 3. swap p and q
         * 4. reverse elements [p+1, nums.length]
         */
        if (nums.length <= 1) {
            return false;
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
            return false;
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
        return true;

    }

    private void reverse(int[] nums, int start) {
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