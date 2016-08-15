import java.util.HashMap;
import java.util.Map;

/**
 * 倒不复杂，没什么算法，只是思路要清晰
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean positive = true;
        if ((double)numerator / denominator < 0) {
            positive = false;
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        StringBuilder builder = new StringBuilder();
        if (!positive) {
            builder.append('-');
        }
        builder.append(num / den);
        num = num % den * 10;

        if (num == 0) {
            return builder.toString();
        }

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        builder.append('.');

        while (num != 0) {
            if (map.containsKey(num)) {
                int i = map.get(num);
                builder.insert(i, '(');
                builder.append(')');
                break;
            }
            map.put(num, builder.length());
            if (num < den) {
                builder.append(0);
                num *= 10;
                continue;
            } else {
                builder.append(num / den);
                num = num % den * 10;
            }
        }
        return builder.toString();
    }
}