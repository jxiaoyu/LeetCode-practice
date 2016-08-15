/**
 * 初拿到这题觉得好难，情况好多，不知从何下手
 * 接下来联想到语法树的构建，树的构建情况也很多，如何构建？
 * 树这种数据结构跟递归思想联系很紧密，应该想到递归来处理。
 * 想到这里就简单了，用个 Map 保存计算结果，写完居然一次过
 * 
 * 在这之前练了不少树的题目，总结下规律就比较自然能想到递归。
 * 所以一方面是多练，另一方面是要从练习中总结出规律。
 * 一些问题的解决思路总是对应着一些思想，掌握了思想，就不容易忘记。
 */
public class Solution {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ints = new ArrayList<Integer>();
        List<Character> ops = new ArrayList<Character>();

        int num = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                ints.add(num);
                num = 0;
                ops.add(c);
            }
        }
        ints.add(num);

        Map<String, List<Integer>> dp = new HashMap<String, List<Integer>>();
        return solve(0, ints.size() - 1, dp, ints, ops);
    }

    private List<Integer> solve(int l, int r, Map<String, List<Integer>> dp, List<Integer> ints, List<Character> ops) {
        String key = l + " " + r;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        List<Integer> list = new ArrayList<Integer>();
        if (l == r) {
            list.add(ints.get(l));
        } else {
            for (int i = l; i < r; i++) {
                List<Integer> leftList = solve(l, i, dp, ints, ops);
                List<Integer> rightList = solve(i + 1, r, dp, ints, ops);

                for (Integer m : leftList) {
                    for (Integer n : rightList) {
                        int val = 0;
                        switch (ops.get(i)) {
                            case '+':
                                val = m + n;
                                break;
                            case '-':
                                val = m - n;
                                break;
                            case '*':
                                val = m * n;
                                break;
                        }
                        list.add(val);
                    }
                }
            }
        }
        dp.put(key, list);
        return list;
    }
}