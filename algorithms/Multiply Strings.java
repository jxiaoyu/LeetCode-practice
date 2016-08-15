/**
 * 注意就考察乘法的实现及相关类的使用
 * 细节要注意 0 的处理
 * 代码可以写得更简洁些
 */
public class Solution {
    public String multiply(String num1, String num2) {

        if (num1 == null || num1 == null || num1.length() * num2.length() == 0) {
            return null;
        }

        if ((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num1.charAt(0) == '0')) {
            return "0";
        }

        List<Integer> res = new ArrayList<Integer>();
        int add = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            for (int j = num1.length() - 1; j >= 0; j--) {
                int index = num2.length() - 1 - i + num1.length() - 1 - j;
                if (index > res.size() - 1) {
                    res.add(0);
                }
                Integer d = res.get(index);
                int val = Character.getNumericValue(num1.charAt(j)) * Character.getNumericValue(num2.charAt(i)) + add + d;
                res.set(index, val % 10);
                add = val / 10;
            }
            if (add > 0) {
                res.add(add);
                add = 0;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            builder.append(res.get(i));
        }
        return builder.toString();
    }
}