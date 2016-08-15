import java.util.LinkedList;
import java.util.List;

/**
 * 这是我一开始的思路，比较简单直接，遍历一遍，把数字和运算符分别保存到两个 list 里，先做乘除运算，再做加减运算
 * 但是代码看起来比较冗余，而且过最大的那个测试用例的时候超时了，(⊙︿⊙)
 */
public class Solution {
    public int calculate(String s) {
        List<Integer> ints = new LinkedList<Integer>();
        List<Character> ops = new LinkedList<Character>();

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals(' ')) {
                continue;
            } else if (c - '0' >= 0 && c - '0' <= 9) {
                num = num * 10 + c - '0';
            } else {
                ops.add(c);
                ints.add(num);
                num = 0;
            }
        }
        ints.add(num);

        int i = 0;
        while (i < ops.size()) {
            Character c = ops.get(i);
            if (c.equals('*') || c.equals('/')) {
                ops.remove(i);
                int result = 0, r = ints.remove(i + 1), l = ints.remove(i);
                switch (c) {
                    case '*':
                        result = l * r;
                        break;
                    case '/':
                        result = l / r;
                        break;
                }
                if (i >= ints.size()) {
                    ints.add(result);
                } else {
                    ints.add(i, result);
                }
            } else {
                i++;
            }
        }

        i = 0;
        while (i < ops.size()) {
            Character c = ops.get(i);
            if (c.equals('+') || c.equals('-')) {
                ops.remove(i);
                int result = 0, r = ints.remove(i + 1), l = ints.remove(i);
                switch (c) {
                    case '+':
                        result = l + r;
                        break;
                    case '-':
                        result = l - r;
                        break;
                }
                if (i >= ints.size()) {
                    ints.add(result);
                } else {
                    ints.add(i, result);
                }
            } else {
                i++;
            }
        }

        return ints.get(0);
    }
}