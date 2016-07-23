/**
 * dfs 没什么难度
 */
public class Solution {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, new ArrayList<>(), target);
        return list;
    }

    private void dfs(int[] candidates, int pos, List<Integer> res, int remain) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            list.add(new ArrayList(res));
        }
        for (int i = pos; i < candidates.length; i++) {
            for (int j = 1; remain - j * candidates[i] >= 0; j++) {
                for (int k = 0; k < j; k++) {
                    res.add(candidates[i]);
                }
                dfs(candidates, i + 1, res, remain - j * candidates[i]);
                for (int k = 0; k < j; k++) {
                    res.remove(res.size() - 1);
                }
            }
        }
    }
}