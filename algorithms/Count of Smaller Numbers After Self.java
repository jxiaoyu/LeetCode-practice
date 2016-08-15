/**
 * 求逆序数，用 mergeSort 的方法。时间复杂度 nlg(n)
 */
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        // 因为要求每个位置的逆序数，不能对原数组排序，所以只能对数组的 index 排序
        int[] index = new int[nums.length], count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        mergeSort(index, nums, count, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            result.add(count[i]);
        }
        return result;
    }

    private void mergeSort(int[] index, int[] nums, int[] count, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (end - start) / 2 + start;
        mergeSort(index, nums, count, start, mid);
        mergeSort(index, nums, count, mid + 1, end);
        merge(index, nums, count, start, end);
    }

    private void merge(int[] index, int[] nums, int[] count, int start, int end) {
        int mid = (end - start) / 2 + start, left = start, right = mid + 1, cur = 0, rightCount = 0;
        int[] sortedIndex = new int[end - start + 1];

        while (left <= mid && right <= end) {
            if (nums[index[right]] < nums[index[left]]) {
                sortedIndex[cur++] = index[right++];
                rightCount++;
            } else {
                count[index[left]] += rightCount;
                sortedIndex[cur++] = index[left++];
            }
        }
        while (left <= mid) {
            count[index[left]] += rightCount;
            sortedIndex[cur++] = index[left++];
        }
        while (right <= end) {
            sortedIndex[cur++] = index[right++];
        }
        
        /**
         * 一开始上面这段我是这么写的，过大 testcase 的时候超时了
         * 关键就在于里面那个 for 循环，把这段的时间复杂度变成了 O(n^2)
         * 开始根本没意识到，觉得 mergeSort 的时间复杂度明明是 nlg(n)，怎么会超时。细节是魔鬼
         */
        // while (left <= mid || right <= end) {
        //     if (left > mid) {
        //         sortedIndex[cur++] = index[right++];
        //     } else if (right > end) {
        //         sortedIndex[cur++] = index[left++];
        //     } else if (nums[index[right]] < nums[index[left]]) {
        //         sortedIndex[cur++] = index[right++];
        //         for (int i = left; i <= mid; i++) {
        //             count[index[i]]++;
        //         }
        //     } else {
        //         sortedIndex[cur++] = index[left++];
        //     }
        // }
        for (int i = start; i <= end; i++) {
            index[i] = sortedIndex[i-start];
        }
    }
}