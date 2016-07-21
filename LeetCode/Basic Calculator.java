/**
 * 跟 Basic CalculatorII 的思路是一样的
 */
public class Solution {
    public int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        char op = '+';
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c.equals('(')) {
                stack.push(Character.toString(op) + c);
                op = '+';
            } else if (c.equals(' ')) {
                continue;
            } else if (Character.isDigit(c)) {
                sb.append(c);
            } else if (c.equals(')')) {
                int num = 0;
                if (sb.length() > 0 ) {
                    num = Integer.parseInt(op + sb.toString());
                }
                sb.setLength(0);
                while (true) {
                    String top = stack.pop();
                    if (top.equals("+(")) {
                        stack.push(Integer.toString(num));
                        break;
                    }
                    if (top.equals("-(")) {
                        stack.push(Integer.toString(-num));
                        break;
                    }
                    num += Integer.parseInt(top);
                }
            } else {
                if (sb.length() > 0) {
                    stack.push(op + sb.toString());
                }
                sb.setLength(0);
                op = c;
            }
        }
        if (sb.length() > 0) {
            stack.push(op + sb.toString());
        }

        while (!stack.empty()) {
            result += Integer.parseInt(stack.pop());
        }
        return result;
    }
}