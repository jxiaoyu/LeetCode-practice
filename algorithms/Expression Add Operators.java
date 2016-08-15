/**
 * 受 Basic Calculator II 的影响，想到最直接的方法就是枚举所用的符号组合，调用 Basic Calculator II 的方法计算结果是否相等
 * 而 dfs 相当于是上面暴力求解的改进，下一步总是可以利用前一步的结果，不用像上面那样每个组合都是从头计算
 * 而且计算可以不用栈的
 * 
 * 有两个点要注意
 * 1. 计算的中间结果有可能超过 int 型
 * 2. 10 - 05 这样的运算式是不合法的
 */
public class Solution {
    
    private List<String> list = new ArrayList<>();
    
    public List<String> addOperators(String num, int target) {
        if (num == null) {
            return list;
        }
        dfs(num, 0, target, 0, "");
        return list;
    }
    
    private void dfs(String num, int pos, long target, long preVal, String res) {
        if (pos == num.length()) {
            if (target - preVal == 0) {
                list.add(res);
            }
            return;
        }
        long val = 0;
        for (int i = pos; i < num.length(); i++) {
            if (val == 0 && i > pos) {
                return;
            }
            val = val * 10 + num.charAt(i) - '0';
            if (res == "") {
                dfs(num, i + 1, target - preVal, val, res + val);
            } else {
                dfs(num, i + 1, target - preVal, val, res + '+' + val);
                dfs(num, i + 1, target - preVal, -val, res + '-' + val);
                dfs(num, i + 1, target, preVal * val, res + '*' + val);
            }
        }
    }
}