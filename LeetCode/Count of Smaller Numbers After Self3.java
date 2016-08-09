/**
 * Binary Indexed Tree
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < sorted.length; i++) {
            nums[i] = Arrays.binarySearch(sorted, nums[i]);
        }
        Integer[] result = new Integer[nums.length];
        int[] bit = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = query(bit, nums[i] - 1);
            // bit 对应一个数组 x， x[i] = 1 表示排在 i 位上的数在 x 中
            add(bit, nums[i], 1);
        }
        return Arrays.asList(result);
    }

    private int query(int[] bit, int index) {
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    private void add(int[] bit, int index, int val) {
        index = index + 1;
        while (index < bit.length) {
            bit[index] += val;
            index += index & (-index);
        }
    }
}