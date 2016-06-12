import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jxiao on 2016/6/11.
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(new ArrayList<>(), nums, visited);
        return perms;

    }

    private List<List<Integer>> perms = new ArrayList<>();

    private void dfs(List<Integer> seq, int[] nums, boolean[] visited) {

        if (seq.size() == nums.length) {
            // 注意1：不能直接 add seq
            perms.add(new ArrayList<Integer>(seq));
            return;
        }

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }

            /**
             * 技巧1：dfs 一层的入参要保持独立互不干扰
             * 这种修改再还原的方式比新建对象 copy 修改要快
             */
            seq.add(nums[i]);
            visited[i] = true;
            dfs(seq, nums, visited);
            seq.remove(seq.size() - 1);
            visited[i] = false;
        }
    }
}