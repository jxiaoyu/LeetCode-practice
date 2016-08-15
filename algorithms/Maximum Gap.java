/**
 * 桶排序的思想
 * Suppose there are N elements in the array, the min value is min and the max value is max. 
 * Then the maximum gap will be no smaller than ceiling[(max - min ) / (N - 1)].
 */
class Bucket {
    int max, min;

    public Bucket(int val) {
        max = val;
        min = val;
    }

    public void add(int val) {
        max = Math.max(max, val);
        min = Math.min(min, val);
    }
}

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int min = nums[0], max = nums[0];
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int size = (int)Math.ceil((max - min) / (nums.length - 1.0));

        if (size == 0) {
            return 0;
        }
        Bucket[] buckets = new Bucket[(int)Math.ceil((max - min + 1.0) / size)];

        for (int i : nums) {
            int index = (i - min) / size;
            if (buckets[index] == null) {
                buckets[index] = new Bucket(i);
            } else {
                buckets[index].add(i);
            }
        }

        int result = 0, prev = buckets[0].max;

        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] == null) {
                continue;
            }
            result = Math.max(result, buckets[i].min - prev);
            prev = buckets[i].max;
        }
        return result;
    }
}