/**
 * 用 Binary Indexed Tree 实现了一遍
 * http://huntzhan.org/leetcode-count-of-range-sum/
 */
class BIT {
    private int[] bit;

    public int query(int index) {
        index = index + 1;
        int sum = 0;
        while (index > 0) {
            sum += bit[index];
            index -= index & (-index);
        }
        return sum;
    }

    public void add(int index, int val) {
        index = index + 1;
        while (index < bit.length) {
            bit[index] += val;
            index += index & (-index);
        }
    }

    public BIT(int len) {
        bit = new int[len+1];
    }
}

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSum = new long[nums.length+1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        long[] sorted = prefixSum.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < prefixSum.length; i++) {
            prefixSum[i] = Arrays.binarySearch(sorted, prefixSum[i]);
        }
        BIT bit = new BIT(prefixSum.length);
        int result = 0;
        for (int i = prefixSum.length - 1; i > 0; i--) {
            bit.add((int)prefixSum[i], 1);
            int upIndex = Arrays.binarySearch(sorted, sorted[(int)prefixSum[i-1]] + upper);
            int lowIndex = Arrays.binarySearch(sorted, sorted[(int)prefixSum[i-1]] + lower - 1);
            if (upIndex == -1) {
                continue;
            }
            if (lowIndex == -1) {
                upIndex = upIndex < 0 ? -upIndex - 2 : upIndex;
                result += bit.query(upIndex);
            } else {
                upIndex = upIndex < 0 ? -upIndex - 2 : upIndex;
                lowIndex = lowIndex < 0 ? -lowIndex - 2 : lowIndex;
                result += bit.query(upIndex) - bit.query(lowIndex);
            }
        }
        return result;
    }
}